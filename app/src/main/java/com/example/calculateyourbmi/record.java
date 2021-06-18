package com.example.calculateyourbmi;

public class record {
    private String key;
    private String weight;
    private String height;
    private String age;
    private String typeofuser;

    public record(){

    }


    public record(String weight2, String typeofuser, String age2, String mintprogress) {
        this.weight = weight2;
        this.typeofuser = typeofuser;
        this.age = age2;
        this.height = mintprogress;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }


    public String getTypeofuser() {
        return typeofuser;
    }

    public void setTypeofuser(String typeofuser) {
        this.typeofuser = typeofuser;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}
