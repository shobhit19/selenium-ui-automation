package com.practice.tests;

public final class HomePageTests extends BaseTest{

    private HomePageTests(){

    }

//    /**
//     *  1. Validate whether the title is containing Google Search or google search
//     *  2. validate whether the title is not null and the length of title is greater than 15 and less than 100
//     *  3. Check for the links in the pages --> Testing mini bytes - You tube
//     *  4. Number of links displayed is exactly 10 or 15
//     *  */
//    @Test
//    public void test1(){
//        DriverManager.getDriver().findElement(By.name("q")).sendKeys("Testing mini bytes - Youtube", Keys.ENTER);
//        String title = DriverManager.getDriver().getTitle();
//        Assert.assertTrue(Objects.nonNull(title));
//        Assert.assertTrue(title.toLowerCase().contains("google search"));
//        Assert.assertTrue(title.length()>15 && title.length()<100);
//        List<WebElement> elements = DriverManager.getDriver().findElements(By.xpath("//h3/span"));
//        Assert.assertEquals(elements.size(),10);
//
//        boolean isElementPresent = false;
//        for(WebElement element : elements){
//            if(element.getText().equalsIgnoreCase("Testing Mini Bytes - YouTube")){
//                isElementPresent=true;
//                break;
//            }
//        }
//        Assert.assertTrue(isElementPresent,"Testing mini bytes not found");
//
//    }

}
