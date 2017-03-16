package com.example.chegu.diethouse.network;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by chegu on 17/11/16.
 */
public class DataBMI {
    private static DataBMI ourInstance = new DataBMI();

    public static DataBMI getInstance() {
        return ourInstance;
    }

    private DataBMI() {
    }
        @SerializedName("username")
        @Expose
        private String username;
        @SerializedName("goal")
        @Expose
        private String goal;
        @SerializedName("activeStatus")
        @Expose
        private String activeStatus;
        @SerializedName("sex")
        @Expose
        private String sex;
        @SerializedName("age")
        @Expose
        private Double age;
        @SerializedName("height")
        @Expose
        private Double height;
        @SerializedName("weight")
        @Expose
        private Double weight;
        @SerializedName("goalWeight")
        @Expose
        private Double goalWeight;
        @SerializedName("weeklyGoal")
        @Expose
        private Double weeklyGoal;
        @SerializedName("calorieCount")
        @Expose
        private Integer calorieCount;
        @SerializedName("bmr")
        @Expose
        private Object bmr;

        /**
         *
         * @return
         * The username
         */
        public String getUsername() {
            return username;
        }

        /**
         *
         * @param username
         * The username
         */
        public void setUsername(String username) {
            this.username = username;
        }

        /**
         *
         * @return
         * The goal
         */
        public String getGoal() {
            return goal;
        }

        /**
         *
         * @param goal
         * The goal
         */
        public void setGoal(String goal) {
            this.goal = goal;
        }

        /**
         *
         * @return
         * The activeStatus
         */
        public String getActiveStatus() {
            return activeStatus;
        }

        /**
         *
         * @param activeStatus
         * The activeStatus
         */
        public void setActiveStatus(String activeStatus) {
            this.activeStatus = activeStatus;
        }

        /**
         *
         * @return
         * The sex
         */
        public String getSex() {
            return sex;
        }

        /**
         *
         * @param sex
         * The sex
         */
        public void setSex(String sex) {
            this.sex = sex;
        }

        /**
         *
         * @return
         * The age
         */
        public Double getAge() {
            return age;
        }

        /**
         *
         * @param age
         * The age
         */
        public void setAge(Double age) {
            this.age = age;
        }

        /**
         *
         * @return
         * The height
         */
        public Double getHeight() {
            return height;
        }

        /**
         *
         * @param height
         * The height
         */
        public void setHeight(Double height) {
            this.height = height;
        }

        /**
         *
         * @return
         * The weight
         */
        public Double getWeight() {
            return weight;
        }

        /**
         *
         * @param weight
         * The weight
         */
        public void setWeight(Double weight) {
            this.weight = weight;
        }

        /**
         *
         * @return
         * The goalWeight
         */
        public Double getGoalWeight() {
            return goalWeight;
        }

        /**
         *
         * @param goalWeight
         * The goalWeight
         */
        public void setGoalWeight(Double goalWeight) {
            this.goalWeight = goalWeight;
        }

        /**
         *
         * @return
         * The weeklyGoal
         */
        public Double getWeeklyGoal() {
            return weeklyGoal;
        }

        /**
         *
         * @param weeklyGoal
         * The weeklyGoal
         */
        public void setWeeklyGoal(Double weeklyGoal) {
            this.weeklyGoal = weeklyGoal;
        }

        /**
         *
         * @return
         * The calorieCount
         */
        public Integer getCalorieCount() {
            return calorieCount;
        }

        /**
         *
         * @param calorieCount
         * The calorieCount
         */
        public void setCalorieCount(Integer calorieCount) {
            this.calorieCount = calorieCount;
        }

        /**
         *
         * @return
         * The bmr
         */
        public Object getBmr() {
            return bmr;
        }

        /**
         *
         * @param bmr
         * The bmr
         */
        public void setBmr(Object bmr) {
            this.bmr = bmr;
        }


}
