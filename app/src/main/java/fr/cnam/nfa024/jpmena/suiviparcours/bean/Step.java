package fr.cnam.nfa024.jpmena.suiviparcours.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Step implements Serializable {
    private Integer mRoomFrom;
    private Integer mRoomTo;
    private String mDisplacment;
    private Boolean mDone;

    public Step(Integer roomFrom, Integer roomTo, String displacment, Boolean done) {
        mRoomFrom = roomFrom;
        mRoomTo = roomTo;
        mDisplacment = displacment;
        mDone = done;
    }

    public Integer getmRoomFrom() {
        return mRoomFrom;
    }

    public void setmRoomFrom(Integer mRoomFrom) {
        this.mRoomFrom = mRoomFrom;
    }

    public Integer getmRoomTo() {
        return mRoomTo;
    }

    public void setmRoomTo(Integer mRoomTo) {
        this.mRoomTo = mRoomTo;
    }

    public String getmDisplacment() {
        return mDisplacment;
    }

    public void setmDisplacment(String mDisplacment) {
        this.mDisplacment = mDisplacment;
    }

    public Boolean getmDone() {
        return mDone;
    }

    public void setmDone(Boolean mDone) {
        this.mDone = mDone;
    }

    @Override
    public boolean equals(Object o) {

        // If the object is compared with itself then return true
        if (o == this) {
            return true;
        }

        /* Check if o is an instance of Complex or not
          "null instanceof [type]" also returns false */
        if (!(o instanceof Step)) {
            return false;
        }

        // typecast o to Complex so that we can compare data members
        Step c = (Step) o;

        // Compare the data members and return accordingly
        return Integer.compare(mRoomFrom, c.getmRoomFrom()) == 0
                && Integer.compare(mRoomTo, c.getmRoomTo()) == 0;
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
