package salesforce.testing;

import java.util.List;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class exercises extends AbstractSetUpAndDown {

	@Test
	public void showAdsUrlsInConsole() {
		// listAds is a list which contains the content of the ads section
		List<WebElement> listAds = driver.findElements(By.cssSelector(property.cssAds));
		
		// if list is empty then there are no ads to show, otherwise I show them
		if (listAds.size() == 0) {
			System.out.println("\n");
			System.out.println("no se hallaron anuncios");
		}	
		else {
			// Listing the ads
			System.out.println("Anuncios:");
			System.out.println("*********");
			
			for(int i=0;i<listAds.size();i++) {
				String elementText = listAds.get(i).getText();
				if (elementText.toLowerCase().toString().contains("anuncio") || elementText.toLowerCase().toString().contains("ad"))
					System.out.println(elementText.substring(7)); 
			}
		}
	}
	
	
	@Test
	public void showArgentinianUrlsInConsole() {
		// cantPages represents the quantity of pages that the search covers
		int cantPages = Integer.parseInt(property.cantPages);
		
		// urls will contain the urls of the search
		List<WebElement> urls = driver.findElements(By.xpath(property.xpathUrlsSearch));
		
    	// Listing the argentinian urls
		System.out.println("\n");
		System.out.println("URLs argentinas:");
    	System.out.println("****************");
		
		// I look on the amount of pages specified by cantPages and put the content of the urls in the url list
	    for (int i=0; i< cantPages;i++) {
	    	
	    	urls = driver.findElements(By.xpath(property.xpathUrlsSearch));
	    	
	    	// I go through the url list and print in console the argentinian urls
	    	for(WebElement url : urls)
	        	{
	            	String text = url.getAttribute("href");
	            	if (text.toLowerCase().toString().contains(".ar"))
	            		System.out.println("pagina " + (i+1) + " de la busqueda - " + text); 
	        	}
	    	
	    	// Go to the next page
	    	driver.findElement(By.id(property.idNextButton)).click();
	    }
	}
	
	
	
	@Test
	public void showPositioningInConsole() {
		
		String keyWord = property.keyWord;
		
		/******** ADS *********/
		
		// listAds is a list which contains the content of the ads section
		List<WebElement> listAds = driver.findElements(By.cssSelector(property.cssAds));
		
		// if list is empty then there are no ads to show, otherwise I show them
		if (listAds.size() == 0) {
			System.out.println("\n");
			System.out.println("no se hallaron anuncios con la keyWord " + keyWord + "\n");
		}	
		else {
			// Listing the ads
			System.out.println("\n");
			System.out.println("Anuncios posicionados:");
			System.out.println("**********************");
			
			for(int i=0;i<listAds.size();i++) {
				String elementText = listAds.get(i).getText();
				if (elementText.toLowerCase().toString().contains(keyWord.toLowerCase()))
					System.out.println(elementText.substring(7)); 
			}
		}
		
		/******** SIDE *********/
		
		// listSideUrl is a list which contains the content of the title of the right side of search
		List<WebElement> listSideUrl = driver.findElements(By.cssSelector(property.cssRightSide));
		
		// if list is empty then there are no side urls to show, otherwise I show them
		if (listSideUrl.size() == 0) {
			System.out.println("\n");
			System.out.println("no se hallaron anuncios laterales con la keyword " + keyWord + "\n");
		}	
		else {
			// Listing the positioning keywords
			System.out.println("\n");
			System.out.println("URLs posicionadas lateralmente:");
			System.out.println("*******************************");
			
			for(int i=0;i<listSideUrl.size();i++) {
				String elementText = listSideUrl.get(i).getText();
				if (elementText.toLowerCase().toString().contains(keyWord.toLowerCase()))
					System.out.println(elementText); 
			}

		}
		
		/******** ORGANIC *********/
		
		// urls will contain the organic urls of the search
		List<WebElement> urls = driver.findElements(By.xpath(property.xpathUrlsSearch));
		
		// if list is empty then there are no side urls to show, otherwise I show them
		if (urls.size() == 0) {
			System.out.println("\n");
			System.out.println("no se hallaron urls organicas con la keyword " + keyWord + "\n");
		}	
		else {
			// Listing the positioning keywords
			System.out.println("\n");
			System.out.println("URLs organicas:");
			System.out.println("***************");
			
			int i = 1;
			
	    	// I go through the url list and print in console the organic urls
	    	for(WebElement url : urls) {
	    		
            	String text = url.getAttribute("href");
            	if (text.toLowerCase().toString().contains(keyWord.toLowerCase()))
            		System.out.println("link en posicion " + i + " de la busqueda: " + text);
            	i++;
        	}

		}
	}
	
	
}
