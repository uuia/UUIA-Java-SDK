package info.uuia.sdk.domain.schedule;

public class DetailItem {
    private int[] weeks;
    private int[] days;
    private int[] sections;
    private String classroom;

    public DetailItem(int[] weeks, int[] days, int[] sections, String classroom) {
        this.weeks = weeks;
        this.days = days;
        this.sections = sections;
        this.classroom = classroom;
    }

    public int[] getWeeks() {
        return weeks;
    }

    public int[] getDays() {
        return days;
    }

    public int[] getSections() {
        return sections;
    }

    public String getClassroom() {
        return classroom;
    }
}
