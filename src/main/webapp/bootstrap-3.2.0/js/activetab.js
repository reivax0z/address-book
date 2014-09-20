var tabs = ['search_tab', 'manage_tab', 'compare_tab'];
var tabs_content = ['search', 'manage', 'compare'];
var unselectedTab = '';
var selectedTab = 'active';
var unselectedTabContent = 'tab-pane';
var selectedTabContent = 'tab-pane active';

function setActiveTab(tabId){
	for(var i=0; i<tabs.length; i++){
		if(i==tabId){
			document.getElementById(tabs[i]).className = selectedTab;
			document.getElementById(tabs_content[i]).className = selectedTabContent;
		} else{
			document.getElementById(tabs[i]).className = unselectedTab;
			document.getElementById(tabs_content[i]).className = unselectedTabContent;
		}
	}
}