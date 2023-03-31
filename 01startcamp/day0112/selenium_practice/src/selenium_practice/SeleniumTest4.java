package selenium_practice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumTest4 {
	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.letskorail.com/");
		
		System.out.println(driver.getWindowHandles());
		
		// 메인창의 이름 저장
		String mainPage = driver.getWindowHandle(); // 제일 첫번째꺼 하나만
		
		for (String handle: driver.getWindowHandles()) {
			// 메인페이지와 이름이 다른 경우를 찾아내야함!
			if(!handle.equals(mainPage)) {
				// 창을 닫는 액션
				driver.switchTo().window(handle).close();
			}
		}
		
		driver.switchTo().window(mainPage);
	}

}
