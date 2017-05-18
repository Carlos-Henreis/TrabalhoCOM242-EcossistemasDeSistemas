/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.controllers;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import java.util.Scanner;
import main.Server.JavaApp;

import main.interfaces.pythonInterfaceGrpc;
import main.interfaces.pythonInterfaceGrpc.pythonInterfaceBlockingStub;
import main.interfaces.pythonInterfaceGrpc.pythonInterfaceStub;

import main.interfaces.rubyInterfaceGrpc;
import main.interfaces.rubyInterfaceGrpc.rubyInterfaceBlockingStub;
import main.interfaces.rubyInterfaceGrpc.rubyInterfaceStub;
import main.messages.CombatOuterClass;
import main.messages.CombatOuterClass.Combat;
import main.messages.DiceOuterClass.Dice;
import main.messages.DiceOuterClass.DiceType;
import main.messages.DiceOuterClass.DiceType.Type;

import main.messages.HeroOuterClass;
import main.messages.HeroOuterClass.Hero;
import main.messages.HeroOuterClass.HeroID;
import main.messages.HeroOuterClass.Heroes;

import main.messages.MonsterOuterClass;
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
                this.pyHost = in.nextLine();
                setPythonStub();
                break;
            case "rbip":
                System.out.print("Ruby - Digite o IP:");
                this.rbHost = in.nextLine();
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
                while (monsters.getMonsterCount() != 0) {

                    System.out.println("Seus adversários\n##########");
                    for (int i = 0; i < monsters.getMonsterCount(); i++) {
                        System.out.print(monsters.getMonster(i).getId() + " ");
                        System.out.print(monsters.getMonster(i).getName());
                        System.out.println(" HP [" + monsters.getMonster(i).getHealth() + "]");

                    }
                    System.out.println("##########");

                    System.out.println("\nSua Equipe\n##########");
                    for (int i = 0; i < heroes.getHeroCount(); i++) {
                        System.out.print(heroes.getHero(i).getId() + " ");
                        System.out.print(heroes.getHero(i).getName());
                        System.out.println(" HP [" + monsters.getMonster(i).getHealth() + "]");
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
                    if(c.getWhoAttacks() == Combat.attacker.hero) {
                        atk = c.getAHero();
                        heroes = rubyStub.setHero(atk);
                    }
                    if (!c.getDeadDefender()) {
                        System.out.println("O monstro não foi derrotado, ele irá atacar!");
                        cBuilder = Combat.newBuilder(c).setWhoAttacks(Combat.attacker.monster);
                        c = cBuilder.build();
                        JavaApp.ThisCalculateCombat(c);
                    } else {
                        System.out.println("Monstro " + def.getName() + " derrotado");
                    }

                }
                break;
            case "rh":
                if(rbHost == null) {
                    System.out.println("Defina o IP da máquina Ruby");
                    break;
                }
                Hero.Builder hBuilder = Hero.newBuilder();
                System.out.print("Id do héroi: ");
                hBuilder.setId(in.nextInt());
                System.out.print("Nome do hero: ");
                hBuilder.setName(in.nextLine());
                System.out.print("Força do hero: ");
                hBuilder.setStrength(in.nextInt());
                System.out.print("Resistência do hero: ");
                hBuilder.setResistance(in.nextInt());
                System.out.print("Vida do hero: ");
                int hHp = in.nextInt();
                hBuilder.setHealth(hHp);
                hBuilder.setMaxHealth(hHp);
                Hero h = hBuilder.build();
                
                Heroes hs = rubyStub.setHero(h);
                
                break;
            case "sh":
                Heroes all = rubyStub.getHero(HeroID.newBuilder().setId(-1).build());
                Hero newhero = null;
                System.out.println("Um herói se juntou a campanha!");
                for(int i = 0 ; i < all.getHeroCount() ; i++) {
                    newhero = all.getHero(i);
                    System.out.println("\nID: " + newhero.getId());
                    System.out.println("Nome: " + newhero.getName());
                    System.out.println("Força: " + newhero.getStrength());
                    System.out.println("Resistência: " + newhero.getResistance());
                    System.out.println("Vida: " + newhero.getHealth() + "/" + newhero.getMaxHealth());
                }
                break;
            case "rd":
                System.out.print("Entre com o tipo de dado(D4, D6, D8, D10, D12, D20, D100): ");
                DiceType dt = DiceType.newBuilder().setTipoDado(Type.valueOf(in.nextLine())).build();
                Dice dice = JavaApp.ThisRollDice(dt);
                System.out.println("O dado rolou: "+ dice.getRolledNumber());
                break;
        }
    }

    private void setPythonStub() {
        this.pyChannel = ManagedChannelBuilder.forAddress(this.pyHost, port).usePlaintext(true).build();
        this.pythonStub = pythonInterfaceGrpc.newBlockingStub(pyChannel);
    }

    private void setRubyStub() {
        this.rbChannel = ManagedChannelBuilder.forAddress(this.rbHost, port).usePlaintext(true).build();
        this.rubyStub = rubyInterfaceGrpc.newBlockingStub(rbChannel);
    }
}
