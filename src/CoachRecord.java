package src;

public record CoachRecord(int coachId, int countOfCusomter) {
    @Override
    public int coachId() {
        return coachId;
    }

    @Override
    public int countOfCusomter() {
        return countOfCusomter;
    }

    @Override
    public String toString() {
        return "DescendingCoach{" +
                "coachId=" + coachId +
                ", countOfCusomter=" + countOfCusomter +
                '}';
    }
}
