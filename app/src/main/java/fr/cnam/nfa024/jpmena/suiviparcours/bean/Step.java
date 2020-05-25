package fr.cnam.nfa024.jpmena.suiviparcours.bean;

import java.util.ArrayList;
import java.util.List;

public class Step {
    private Integer RoomFrom;
    private Integer RoomTo;
    private String displacment;
    private Boolean done;

    public Step(Integer roomFrom, Integer roomTo, String displacment, Boolean done) {
        RoomFrom = roomFrom;
        RoomTo = roomTo;
        this.displacment = displacment;
        this.done = done;
    }

    public Integer getRoomFrom() {
        return RoomFrom;
    }

    public void setRoomFrom(Integer roomFrom) {
        RoomFrom = roomFrom;
    }

    public Integer getRoomTo() {
        return RoomTo;
    }

    public void setRoomTo(Integer roomTo) {
        RoomTo = roomTo;
    }

    public String getDisplacment() {
        return displacment;
    }

    public void setDisplacment(String displacment) {
        this.displacment = displacment;
    }

    public Boolean getDone() {
        return done;
    }

    public void setDone(Boolean done) {
        this.done = done;
    }

    public static ArrayList<Step> loadSteps(){
        ArrayList<Step> toLoad = new ArrayList<Step>();
        Step step = new Step(1,2, "UP", false);
        toLoad.add(step);
        step  = new Step(2,3,"LEFT",false);
        toLoad.add(step);
        step  = new Step(3,4,"RIGHT",false);
        toLoad.add(step);
        return toLoad;
    }
}
