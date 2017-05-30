/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.controllers;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import main.Server.JavaApp;

import main.interfaces.pythonInterfaceGrpc;
import main.interfaces.pythonInterfaceGrpc.pythonInterfaceBlockingStub;

import main.interfaces.rubyInterfaceGrpc;
import main.interfaces.rubyInterfaceGrpc.rubyInterfaceBlockingStub;

import main.messages.CombatOuterClass.Combat;
import main.messages.DiceOuterClass.Dice;
import main.messages.DiceOuterClass.DiceType;
import main.messages.DiceOuterClass.DiceType.Type;

import main.messages.HeroOuterClass.Hero;
import main.messages.HeroOuterClass.HeroID;
import main.messages.HeroOuterClass.Heroes;

import main.messages.MonsterOuterClass.Monster;
import main.messages.MonsterOuterClass.MonsterQt;
import main.messages.MonsterOuterClass.Monsters;

/**
 *
 * @author salomon
 */
public class Switcher {

    private pythonInterfaceBlockingStub pythonStub;
    private rubyInterfaceBlockingStub rubyStub;

    private ManagedChannel pyChannel;
    private ManagedChannel rbChannel;
    private Scanner in;
    private String pyHost = null;
    private String rbHost = null;
    int port = 50051;

    public Switcher() {
        in = new Scanner(System.in);
    }

    public void runOption(String op) {
        switch (op) {
            case "pyip":
                System.out.print("Python - Digite o IP:");
                this.pyHost = in.next();
                setPythonStub();
                break;
            case "rbip":
                System.out.print("Ruby - Digite o IP:");
                this.rbHost = in.next();
                setRubyStub();
                break;
            case "sc":
                if (pyHost == null || rbHost == null) {
                    System.out.println("Defina os IPs dos servidores Ruby e Python");
                    break;
                }
                System.out.print("Chame seus herois!\n Digite o Id ou -1 para todos:");
                int call = in.nextInt();
                HeroID hID = HeroID.newBuilder().setId(call).build();

                Heroes heroes = rubyStub.getHero(hID);

                int n;
                System.out.print("Quantidade de monstros: ");
                n = in.nextInt();
                MonsterQt request = MonsterQt.newBuilder().setQt(n).build();

                Monsters monsters = pythonStub.generateMonster(request);
                Combat.Builder cBuilder = Combat.newBuilder();
                while (monsters.getMonsterCount() > 0 && heroes.getHeroCount() > 0 ) {

                    System.out.println("Seus adversários\n##########\nid name hp");
                    for (int i = 0; i < monsters.getMonsterCount(); i++) {
                        System.out.printf("%d %s %d\n",monsters.getMonster(i).getId(),
                                                     monsters.getMonster(i).getName(),
                                                     monsters.getMonster(i).getHealth());

                    }
                    System.out.println("##########");

                    System.out.println("\nSua Equipe\n##########\nid name hp");
                    for (int i = 0; i < heroes.getHeroCount(); i++) {
                        System.out.printf("%d %s %d/%d\n",heroes.getHero(i).getId(),
                                                     heroes.getHero(i).getName(),
                                                     heroes.getHero(i).getHealth(),
                                                     heroes.getHero(i).getMaxHealth());
                    }
                    System.out.println("##########");

                    System.out.print("Digite o id do heroi atacante: ");
                    n = in.nextInt();
                    Hero atk = null;
                    for (int i = 0; i < heroes.getHeroCount(); i++) {
                        if (heroes.getHero(i).getId() == n) {
                            atk = heroes.getHero(i);
                            break;
                        }
                    }
                    if (atk == null) {
                        System.exit(1);
                    }

                    System.out.print("Digite o id do monstro: ");
                    n = in.nextInt();
                    Monster def = null;
                    for (int i = 0; i < monsters.getMonsterCount(); i++) {
                        if (monsters.getMonster(i).getId() == n) {
                            def = monsters.getMonster(i);
                            break;
                        }
                    }
                    if (def == null) {
                        System.exit(1);
                    }

                    cBuilder.setAHero(atk)
                            .setAMonster(def)
                            .setWhoAttacks(Combat.attacker.hero);

                    Combat c = cBuilder.build();
                    c = JavaApp.ThisCalculateCombat(c);
                    
                    for(int i = 0 ; i < monsters.getMonsterCount(); i++) {
                        if(def.getId() == monsters.getMonster(i).getId()) {
                            if(c.getAMonster().getHealth() <= 0){
                                ArrayList<Monster> l = new ArrayList(monsters.getMonsterList());
                                l.remove(i);
                                Monsters.Builder lblder = Monsters.newBuilder().addAllMonster(l);
                                monsters = lblder.build();
                            } else {
                                ArrayList<Monster> l = new ArrayList(monsters.getMonsterList());
                                l.set(i, c.getAMonster());
                                Monsters.Builder lblder = Monsters.newBuilder().addAllMonster(l);
                                monsters = lblder.build();
                            }
                            break;
                        }
                    }
                    
                    if (c.getDeadDefender() == false) {
                        System.out.println("O monstro não foi derrotado, ele irá atacar");
                        c = c.toBuilder().setWhoAttacks(Combat.attacker.monster).build();
                        c = JavaApp.ThisCalculateCombat(c);
                        rubyStub.setHero(c.getAHero());
                        heroes = rubyStub.getHero(hID);
                        if(c.getDeadDefender() == true) {
                            System.out.printf("O heroi %s morreu!\n",atk.getName());
                        }
                    } else {
                        System.out.printf("O monstro %s foi derrotado.\n",def.getName());
                    }
                    

                }
                break;
            case "rh":
                if (rbHost == null) {
                    System.out.println("Defina o IP da máquina Ruby");
                    break;
                }
                Hero.Builder hBuilder = Hero.newBuilder();
                System.out.print("Id do héroi: ");
                hBuilder.setId(in.nextInt());
                System.out.print("Nome do hero: ");
                hBuilder.setName(in.next());
                System.out.print("Força do hero: ");
                hBuilder.setStrength(in.nextInt());
                System.out.print("Resistência do hero: ");
                hBuilder.setResistance(in.nextInt());
                System.out.print("Vida do hero: ");
                int hHp = in.nextInt();
                hBuilder.setHealth(hHp);
                hBuilder.setMaxHealth(hHp);
                Hero h = hBuilder.build();
                try {
                    Heroes hs = rubyStub.addHero(h);
                    for (int i = 0; i < hs.getHeroCount(); i++) {
                        h = hs.getHero(i);
                        System.out.println("\nID: " + h.getId());
                        System.out.println("Nome: " + h.getName());
                        System.out.println("Força: " + h.getStrength());
                        System.out.println("Resistência: " + h.getResistance());
                        System.out.println("Vida: " + h.getHealth() + "/" + h.getMaxHealth());
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            case "sh":
                if (rbHost == null) {
                    System.out.println("Defina o IP da máquina Ruby");
                    break;
                }
                try {
                    Heroes all = rubyStub.getHero(HeroID.newBuilder().setId(-1).build());
                    Hero newhero;

                    for (int i = 0; i < all.getHeroCount(); i++) {
                        newhero = all.getHero(i);
                        System.out.println("\nID: " + newhero.getId());
                        System.out.println("Nome: " + newhero.getName());
                        System.out.println("Força: " + newhero.getStrength());
                        System.out.println("Resistência: " + newhero.getResistance());
                        System.out.println("Vida: " + newhero.getHealth() + "/" + newhero.getMaxHealth());
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }

                break;
            case "rd":
                System.out.print("Entre com o tipo de dado(D4, D6, D8, D10, D12, D20, D100): ");
                DiceType dt = DiceType.newBuilder().setTipoDado(Type.valueOf(in.next())).build();
                Dice dice = JavaApp.ThisRollDice(dt);
                System.out.println("O dado rolou: " + dice.getRolledNumber());
                break;
        }
    }

    private void setPythonStub() {
        this.pyChannel = ManagedChannelBuilder.forAddress(this.pyHost, 50052).usePlaintext(true).build();
        this.pythonStub = pythonInterfaceGrpc.newBlockingStub(pyChannel);
    }

    private void setRubyStub() {
        this.rbChannel = ManagedChannelBuilder.forAddress(this.rbHost, 50053).usePlaintext(true).build();
        this.rubyStub = rubyInterfaceGrpc.newBlockingStub(rbChannel);
    }
}
