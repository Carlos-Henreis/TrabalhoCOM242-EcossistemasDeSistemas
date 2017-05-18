/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.Server;

import java.util.Random;
import main.messages.CombatOuterClass;
import main.messages.DiceOuterClass;
import main.interfaces.javaInterfaceGrpc;
import main.messages.CombatOuterClass.Combat;
import main.messages.CombatOuterClass.Combat.attacker;
import main.messages.DiceOuterClass.DiceType;
import main.messages.HeroOuterClass.Hero;
import main.messages.MonsterOuterClass.Monster;

/**
 *
 * @author salomon
 */
public class JavaApp extends javaInterfaceGrpc.javaInterfaceImplBase {

        @Override
        public void calculateCombat(CombatOuterClass.Combat request,
                io.grpc.stub.StreamObserver<CombatOuterClass.Combat> responseObserver) {
            Combat response = ThisCalculateCombat(request);
            responseObserver.onNext(response);
            responseObserver.onCompleted();
        }

        @Override
        public void rollDice(DiceOuterClass.DiceType request,
                io.grpc.stub.StreamObserver<DiceOuterClass.Dice> responseObserver) {
            DiceOuterClass.Dice response = ThisRollDice(request);
            responseObserver.onNext(response);
            responseObserver.onCompleted();
        }

        public static DiceOuterClass.Dice ThisRollDice(DiceOuterClass.DiceType dt) {
            int i = Integer.parseInt(dt.getTipoDado().toString().substring(1));
            Random rand = new Random(System.currentTimeMillis());
            DiceOuterClass.Dice d = DiceOuterClass.Dice.newBuilder().setType(dt).setRolledNumber(rand.nextInt(i) + 1).build();
            return d;
        }

        public static CombatOuterClass.Combat ThisCalculateCombat(CombatOuterClass.Combat c) {
            DiceType dt = DiceType.newBuilder().setTipoDado(DiceType.Type.D20).build();
            int hit = ThisRollDice(dt).getRolledNumber();
            attacker a = c.getWhoAttacks();
            
            CombatOuterClass.Combat.Builder cBuilder = Combat.newBuilder(c);
            dt = DiceType.newBuilder().setTipoDado(DiceType.Type.D6).build();
            
            if  (a == attacker.hero) {
                Hero atk = c.getAHero();
                Monster def = c.getAMonster();
                
                hit += atk.getStrength();
                if(hit  > def.getResistance()) {
                    int hp = def.getHealth();
                    hp -= ThisRollDice(dt).getRolledNumber();
                    def = Monster.newBuilder(def).setHealth(hp).build();
                    cBuilder.setAMonster(def);
                }
                
                if(def.getHealth() <= 0) {
                    c = cBuilder.setDeadDefender(true).build();
                }
                
            } else {
                Hero def = c.getAHero();
                Monster atk = c.getAMonster();
                
                hit += atk.getStrength();
                
                if(hit  > def.getResistance()) {
                    int hp = def.getHealth();
                    hp -= ThisRollDice(dt).getRolledNumber();
                    def = Hero.newBuilder(def).setHealth(hp).build();
                    cBuilder.setAHero(def);
                }
                
                if(def.getHealth() <= 0) {
                    c = cBuilder.setDeadDefender(true).build();
                } 
            }
            
            return c;
        }
    }