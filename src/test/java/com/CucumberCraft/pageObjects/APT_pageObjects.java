package com.CucumberCraft.pageObjects;



public class APT_pageObjects {
	private static  String searchbox ="//input[@id='ptextcode']";
	private static  String searchBoxLabel="//input[@type='search']/ancestor::div/label[.=' Promo / PST / TA Code ']";
	private static  String magnifierIcon="//div/input[@id='ptextcode']/parent::div/span/button[@type='submit']";
	private static  String CheckboxName="//input[@type='checkbox']/parent::label[.=' Current promos only ']";
	private static  String chechkbox="//input[@type='checkbox']";
	private static  String messages="//input[@id='ptextcode']/parent::div/preceding-sibling::em[.='Required']";
	private static  String noResponseMessage="h5";
	private static  String expand ="//span[.='Promo code: RVGLD']/following-sibling::span/img";
	private static  String allPromocodeBox="//div[@class='card-header bgtransparent noMarginPad']";
	private static String allPromocodeNameinHeading="//div//span/b[contains(text(),'Promo code: ')]";
	private static String allfiledsInPromoBox="//div/app-promodetails//b[contains(text(),'Promotion dates:')]";
	private static String sortByDropdown="//div/label[contains(text(),'Sort by:')]/parent::div//select";
	private static String tabName="//a[.='Search results']";
	private static String date="//table//tbody//tr/td/span[.='18']";
	private static String matChip="//mat-chip/p";
	private static String keywordsMessages="//em/b[.='Special characters not allowed']";
	private static String matChipCancel="//mat-chip/mat-icon[.='cancel']";
	private static String yearInYearBox ="//table//tr/td[.='2017']";
	//private static String otherThanCurrentPage ="//li/[@class='ng-star-inserted']";
	//private static String currentPage ="//span/[@class='ng-star-inserted']";
	//private static String nextPagedisabled ="//li/[@class='pagination-next ng-star-inserted disabled']";
	//private static String previousPagedisabled ="//li/[@class='pagination-previous ng-star-inserted disabled']";
	private static String enabledPagination ="//a[@class='ng-star-inserted']";
	
	private static String diabledPagination ="//li//span[@class='ng-star-inserted']";
	

	
	
//	private static String keywords="//label[.=' Keywords ']";
//	private static String keywordsInputBox="//input[@id='keywordtext']";
//	private static String plusButtonInputBox="//button[@id='bf_kw_plusbutton']";
//	private static String effectiveDateRange="//label[.=' Effective date range ']";
//	private static String fromEffectiveDateRange="//input[@id='bf_fromdate_textbox']";
//	private static String fromEffectiveDateRangeCalenderButton="//button[@id='bf_fromdate_calbutton']";
//	private static String fromorToCalenderObject="//div[@class='bs-calendar-container']";
//	private static String previousButtonInCalender="//button[@class='previous']";
//	private static String nextButtonInCalender="//button[@class='next']";
//	
//	private static String toDateBox="//label[.=' to ']";
//	private static String toEffectiveDateRangeCalenderButton="//button[@id='bf_todate_calbutton']";
//	private static String miscSearchOptions="//label[.=' Misc search options: ']";
//	private static String radioButtonTargetOnly="//input[@id='targetonly']";
//	private static String radioButtonNonTargetOnly="//input[@id='nontargetonly']";
//	private static String checkBoxCurrentPromoOnly="//input@id='bf_misc_currpromo_only']";
//	private static String radioButtonTargetOnlyName="//input[@type='radio']/following-sibling::span[.='Targeted Only']";
//	private static String radioButtonNonTargetOnlyName="//input[@type='radio']/following-sibling::span[.='Non-Targeted Only']";
//	private static String checkBoxCurrentPromoOnlyName="//input[@type='checkbox']/parent::label[.=' Current promos Only ']";
//	private static String partnerCodes="//label[.=' Partner codes ']";
//	private static String partnerCodesInputBox="//input[@id='bf_pc_textbox']";
//	private static String searchButton="//button[.=' Search ']";
//	private static String clearAllButton="//button[.='Clear all']";
	
	public static String getDiabledPagination() {
		return diabledPagination;
	}


	public static String getEnabledPagination() {
		return enabledPagination;
	}		
			
	public static String getYearInYearBox(String name) {
		
		yearInYearBox ="//table//tr/td[.='"+name+"']";
		return yearInYearBox;
	}

	
			public static String getMatChipCancel() {
		return matChipCancel;
	}

	public static String getKeywordsMessages(String name) {
		keywordsMessages="//em/b[.='"+name+"']";
		
		return keywordsMessages;
	}

	public static String getlabelNames(String name) {
		String label="//label[.='"+name+"']";
		return label;		
	}
	
	public static String getButton(String name) {
		String button="//label[.='"+name+"']/parent::div//button";
		return button;
	}
	public static String getButtonByItsName(String name) {
		String button="//button[.='"+name+"']";
		return button;
	}
	
	public static String getTextBox(String name) {
		String textBox="//label[.='"+name+"']/parent::div//input";
		return textBox;
	}
	
	public static String getRadioButton(String name) {
		String radioButton="//input[@type='radio']/following-sibling::span[.='"+name+"']";;
		return radioButton;
	
	}	
	
	public static String checkBox(String name) {
		String checkBox="//input[@type='checkbox']/parent::label[.='"+name+"']";
		return checkBox;
	
	}	
	
	public static String calendar(String name) {
		String calender="//label[.='"+name+"']/parent::div//button";
		return calender;
	
	}
	
	public static String nextOrpreviousCalenderButton(String name) {
		String nextCalenderButton="//button[@class='"+name+"']";
		return nextCalenderButton;
		
	}
	public static String monthOrYear(String name) {
		String monthOrYear="//button[@class='current']/span[.='"+name+"']";
		return monthOrYear;
		
	}
	
	public static String date(String name) {
		 date="//table//tbody//tr/td/span[.='"+name+"']";
		return date;
		
	}
	
	public static String matChip() {
		matChip="//mat-chip/p";
		return matChip;
		
	}
	
	
	public static String getTabName(String name) {
		tabName="//a[.='"+name+"']";
		return tabName;
	}
	public static String getSortByDropdown(String name) {
		return sortByDropdown;
	}
	public static String getAllPromocodeBox(String name) {
		return allPromocodeBox;
	}
	public static String getAllPromocodeNameinHeading(String name) {
		
		return allPromocodeNameinHeading;
	}
	public static String getAllfiledsInPromoBox(String name) {
		allfiledsInPromoBox="//div/app-promodetails//b[contains(text(),"+name+")]";
		return allfiledsInPromoBox;
	}
	public static String getExpand(String name) {
		expand="//span[.='Promo code: "+name+"']/following-sibling::span/img";
		return expand;
	}
	public static String getSearchbox(String name) {
		return searchbox;
	}
	public static String getSearchboxlabel(String name) {
		APT_pageObjects.searchBoxLabel="//input[@type='search']/ancestor::div/label[.='"+name+"']";
		return searchBoxLabel;
	}
	public static String getMagnifiericon(String name) {
		return magnifierIcon;
	}
	public static String getCheckboxname(String name) {
		APT_pageObjects.searchBoxLabel="//input[@type='checkbox']/parent::label[.='"+name+"']";
		return CheckboxName;
	}
	public static String getChechkbox(String name) {
		return chechkbox;
	}
	public static String getRequiredmessage(String name) {
		APT_pageObjects.messages="//input[@id='ptextcode']/parent::div/preceding-sibling::em[.='"+name+"']";
		return messages;
	}
	public static String getNoResponseMessage() {
		return noResponseMessage;
	}
    


}
