package JavaConcepts;

public class Student
{
    private String regNum;

    public Student(final String n)
    {
        regNum = n;
    }

    public String getRegNum()
    {
        return regNum;
    }

    public void setRegNum(final String regNum)
    {
        this.regNum = regNum;
    }

    @Override
    public boolean equals(final Object o)
    {
        System.out.println("going to equals");
        if ((o != null) && (o instanceof Student)) {
            final String regNumofO = ((Student) o).getRegNum();
            if ((regNumofO != null) && regNumofO.equals(getRegNum())) {
                return true;
            }
        }
        return false;
    }

    public int hashCode()
    {
        System.out.println("going to hashcode");
        System.out.println(getRegNum().hashCode());
        return getRegNum().hashCode();
    }

}
