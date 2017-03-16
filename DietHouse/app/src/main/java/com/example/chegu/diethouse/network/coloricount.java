package com.example.chegu.diethouse.network;

/**
 * Created by srikanthakula on 18/11/16.
 */

public class coloricount {

    /**
     * status : 1
     * message : {"sex":"Male","weight":56.6,"height":5.6,"age":0,"goal":"Loose","activeStatus":"Active","goalWeight":52,"weeklyGoal":54,"calorieCount":120,"bmr":"605.9999994039536","username":"complanboy2"}
     */

    private int status;
    /**
     * sex : Male
     * weight : 56.6
     * height : 5.6
     * age : 0
     * goal : Loose
     * activeStatus : Active
     * goalWeight : 52
     * weeklyGoal : 54
     * calorieCount : 120
     * bmr : 605.9999994039536
     * username : complanboy2
     */

    private MessageBean message;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public MessageBean getMessage() {
        return message;
    }

    public void setMessage(MessageBean message) {
        this.message = message;
    }

    public static class MessageBean {
        private String sex;
        private double weight;
        private double height;
        private int age;
        private String goal;
        private String activeStatus;
        private int goalWeight;
        private int weeklyGoal;
        private int calorieCount;
        private String bmr;
        private String username;

        public String getSex() {
            return sex;
        }

        public void setSex(String sex) {
            this.sex = sex;
        }

        public double getWeight() {
            return weight;
        }

        public void setWeight(double weight) {
            this.weight = weight;
        }

        public double getHeight() {
            return height;
        }

        public void setHeight(double height) {
            this.height = height;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public String getGoal() {
            return goal;
        }

        public void setGoal(String goal) {
            this.goal = goal;
        }

        public String getActiveStatus() {
            return activeStatus;
        }

        public void setActiveStatus(String activeStatus) {
            this.activeStatus = activeStatus;
        }

        public int getGoalWeight() {
            return goalWeight;
        }

        public void setGoalWeight(int goalWeight) {
            this.goalWeight = goalWeight;
        }

        public int getWeeklyGoal() {
            return weeklyGoal;
        }

        public void setWeeklyGoal(int weeklyGoal) {
            this.weeklyGoal = weeklyGoal;
        }

        public int getCalorieCount() {
            return calorieCount;
        }

        public void setCalorieCount(int calorieCount) {
            this.calorieCount = calorieCount;
        }

        public String getBmr() {
            return bmr;
        }

        public void setBmr(String bmr) {
            this.bmr = bmr;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }
    }
}
