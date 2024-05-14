package com.practice.dataprovider;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Arrays;

public class DataProviderDependencyInjection {

    @BeforeMethod
    public void setUp(Object [] data){
        System.out.println(Arrays.toString(data));
    }

    @Test(dataProvider = "getData")
    public void test(String username,String password){
        System.out.println(username +":"+password);
    }



    @DataProvider
    public Object [][] getData(){
        return new Object[][]{{"dsfd", "dfewfrew"},
                {"dfde", "e22"}
        };
    }
}
