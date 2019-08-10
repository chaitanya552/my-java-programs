package JavaConcepts;

public class ReportCard
{
    private int mathScore;

    public void setMathScore(final int mathScore)
    {
        this.mathScore = mathScore;
    }

    public ReportCard()
    {
        mathScore = ((int) Math.random() * 100) + 1;
    }

    public int getMathScore()
    {
        return mathScore;
    }
}
