package dataobjects;

import java.util.Random;

public class Person {

    //region Members variables
    private String name;
    private String surname;
    private int socSecNumber;
    private String[] facts;
    private int knownFacts;
    //endregion

    //region Constructors
    public Person(String name, String surname, int socSecNumber, String... facts) {
        this.facts = new String[100];
        this.name = name;
        this.surname = surname;
        this.socSecNumber = socSecNumber;
        knownFacts = 0;
        for (String fact : facts) {
            this.facts[knownFacts++] = fact;
        }
    }
    //endregion

    //region Member functions
    public boolean knowsFact(String fact) {
        for (int i = 0; i < knownFacts; i++) {
            if (facts[i].equals(fact))
                return true;
        }
        return false;
    }

    public String speak(){
        Random random = new Random(System.currentTimeMillis());
        return facts[random.nextInt(knownFacts)];
    }

    public boolean listen(Person personSpeaking, String msg){
        return learn(msg);
    }

    protected boolean learn(String fact){
        if (knowsFact(fact) || knownFacts >= 100)
            return false;
        else {
            facts[knownFacts++] = fact;
            return true;
        }
    }
    //endregion

    //region Get-/Setters
    public int getSocSecNumber() { return socSecNumber; }
    //endregion

}

