import java.util.Arrays;

public class Student {
    private String name;
    private double[] mark;
    private double averagemark;
    private String result;

    public Student(String name, double[] mark){
        this.name = name;
        this.mark = Arrays.copyOf(mark, mark.length);
        calculate();
    }

    private void calculate(){
        double sum = Arrays.stream(mark).sum();
        this.averagemark = sum / mark.length;
        this.result = (averagemark >40) ? "Passed" : "Failed";
    }

    public String getName(){
        return name;
    }
    public double[] getmark(){
        return mark;
    }
    public double getAveragemark(){
        return averagemark;
    }
    public String getResult(){
        return result;
    }

    public String toString(){
        return "Student: " + name + ", Marks: " + Arrays.toString(mark)
                + ", Average mark: " + averagemark
                + ", Result: " + result;
    }
}
