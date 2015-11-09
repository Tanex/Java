package dataobjects;

public class Student extends Person {
    @Override
    public boolean listen(Person personSpeaking, String msg) {
        if (personSpeaking instanceof Teacher)
            return super.listen(personSpeaking, msg);
        else
            return false;
    }

    public Student(String name, String surname, int socSecNumber, String... facts) {
        super(name, surname,socSecNumber, facts);
    }
}

