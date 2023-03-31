package selenium_practice;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
// . -> ~안에
// * -> 전부 다

public class SeleniumTest2 {
	public static void main (String[] args) {
		
		WebDriver driver = new ChromeDriver();
		
		// 내가 원하는 사이트 열어줘~~
		driver.get("https://www.naver.com");
		
		// 증권 버튼 선택자를 가져와줘~~
		WebElement financeBtn = driver.findElement(By.cssSelector("#NM_FAVORITE > div.group_nav > ul.list_nav.NM_FAVORITE_LIST > li:nth-child(3) > a"));
		
		// 증권버튼 클릭!
		financeBtn.click();
		
		// 삼성전자 검색해보기
		// 1. 검색창 선택해보기
		// 검색창 선택자를 가져와줘~~
		WebElement searchInput = driver.findElement(By.cssSelector("#stock_items"));
		
		// 2. 삼성전자 키워드 입력하기 (넣어주기)
		searchInput.sendKeys("삼성전자");
		
		// 3. 검색창 엔터 누르기
		searchInput.sendKeys(Keys.ENTER);
		
		// ctrl + shift + o -> 자동 임포트 import
	}
}
