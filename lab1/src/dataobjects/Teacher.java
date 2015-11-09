package dataobjects;

public class Teacher extends Person {

    private Student[] students;
    private int numStudents;

    public Teacher(String name, String surname, int socSecNumber, String... facts) {
        super(name, surname,socSecNumber, facts);
        students = new Student[100];
        numStudents = 0;
    }

    public boolean teachFact(String fact){
        if (!knowsFact(fact))
            return false;
        else{
            boolean everybodyLearnt = true;
            for (int i = 0; i < numStudents; i++){
                everybodyLearnt = everybodyLearnt && students[i].listen(this, fact);
            }
            return everybodyLearnt;
        }
    }

    public boolean registerStudent(Student student){
        if (numStudents >= 100)
            return false;
        else{
            students[numStudents++] = student;
            return true;
        }
    }

    @Override
    public boolean learn(String fact) {
        return super.learn(fact);
    }
}
