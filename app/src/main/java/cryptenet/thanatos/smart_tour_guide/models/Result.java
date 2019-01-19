package cryptenet.thanatos.smart_tour_guide.models;

public class Result {
    private String path;
    private int expenditure;
    private int duration;

    public Result(String path, int expenditure, int duration) {
        setPath(path);
        setExpenditure(expenditure);
        setDuration(duration);
    }

    public void setPath(String path) {
        this.path = path;
    }

    public void setExpenditure(int expenditure) {
        this.expenditure = expenditure;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getPath() {
        return path;
    }

    public int getExpenditure() {
        return expenditure;
    }

    public int getDuration() {
        return duration;
    }
}
