package SortingOnComplexObject;

import java.util.Date;

public class ImVeryComplexObject {
    private String name;
    private int id;
    private Date startDate;

    public ImVeryComplexObject(String name, int id, Date startDate) {
        this.name = name;
        this.id = id;
        this.startDate = startDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    @Override
    public String toString() {
        return "Name: " + name + " id: " + id + " Start Date: " +  startDate;
    }
}
