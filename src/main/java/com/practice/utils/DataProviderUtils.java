package com.practice.utils;

import org.testng.annotations.DataProvider;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public final class DataProviderUtils {

    private DataProviderUtils(){}

    @SuppressWarnings("DataProviderReturnType")
    @DataProvider
    public static Object[] getData(Method m) {
        String testName = m.getName();
        List<Map<String, String>> list = ExcelUtil.getTestDetails("DATA");
        List<Map<String,String>> smallList = new ArrayList<>();
        for(int i=0;i<list.size();i++){
                if(list.get(i).get("testname").equalsIgnoreCase(testName)){
                    if(list.get(i).get("execute").equalsIgnoreCase("yes")){
                        smallList.add(list.get(i));
                    }
                }
        }
        return smallList.toArray();
    }

}
