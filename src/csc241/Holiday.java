package csc241;

public class Holiday {
    private String month;
    private int day;
    private String name;
    private boolean federal;
    private boolean oswego;

    // Constructor
    public Holiday(String month, int day, String name){
        this.month = month;
        this.day = day;
        this.name = name;
    }

    public void setFederal(boolean federal) {
        this.federal = federal;
    }

    public void setOswego(boolean oswego) {
        this.oswego = oswego;
    }

    public String toString(){
        return month + ":" + day + ":" + name + ":" + federal + ":" + oswego;
    }
}
