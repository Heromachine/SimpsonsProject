package com.example.jessi.simpsonsproject.models.pojo;

import java.util.List;

import com.google.gson.annotations.SerializedName;


public class Meta{

	@SerializedName("src_url")
	private Object srcUrl;

	@SerializedName("repo")
	private String repo;

	@SerializedName("perl_module")
	private String perlModule;

	@SerializedName("example_query")
	private String exampleQuery;

	@SerializedName("js_callback_name")
	private String jsCallbackName;

	@SerializedName("dev_date")
	private Object devDate;

	@SerializedName("description")
	private String description;

	@SerializedName("unsafe")
	private int unsafe;

	@SerializedName("blockgroup")
	private Object blockgroup;

	@SerializedName("src_name")
	private String srcName;

	@SerializedName("maintainer")
	private Maintainer maintainer;

	@SerializedName("src_domain")
	private String srcDomain;

	@SerializedName("tab")
	private String tab;

	@SerializedName("is_stackexchange")
	private Object isStackexchange;

	@SerializedName("id")
	private String id;

	@SerializedName("production_state")
	private String productionState;

	@SerializedName("src_id")
	private int srcId;

	@SerializedName("designer")
	private Object designer;

	@SerializedName("dev_milestone")
	private String devMilestone;

	@SerializedName("name")
	private String name;

	@SerializedName("attribution")
	private Object attribution;

	@SerializedName("signal_from")
	private String signalFrom;

	@SerializedName("topic")
	private List<String> topic;

	@SerializedName("producer")
	private Object producer;

	@SerializedName("developer")
	private List<DeveloperItem> developer;

	@SerializedName("created_date")
	private Object createdDate;

	@SerializedName("live_date")
	private Object liveDate;

	@SerializedName("src_options")
	private SrcOptions srcOptions;

	@SerializedName("status")
	private String status;

	public void setSrcUrl(Object srcUrl){
		this.srcUrl = srcUrl;
	}

	public Object getSrcUrl(){
		return srcUrl;
	}

	public void setRepo(String repo){
		this.repo = repo;
	}

	public String getRepo(){
		return repo;
	}

	public void setPerlModule(String perlModule){
		this.perlModule = perlModule;
	}

	public String getPerlModule(){
		return perlModule;
	}

	public void setExampleQuery(String exampleQuery){
		this.exampleQuery = exampleQuery;
	}

	public String getExampleQuery(){
		return exampleQuery;
	}

	public void setJsCallbackName(String jsCallbackName){
		this.jsCallbackName = jsCallbackName;
	}

	public String getJsCallbackName(){
		return jsCallbackName;
	}

	public void setDevDate(Object devDate){
		this.devDate = devDate;
	}

	public Object getDevDate(){
		return devDate;
	}

	public void setDescription(String description){
		this.description = description;
	}

	public String getDescription(){
		return description;
	}

	public void setUnsafe(int unsafe){
		this.unsafe = unsafe;
	}

	public int getUnsafe(){
		return unsafe;
	}

	public void setBlockgroup(Object blockgroup){
		this.blockgroup = blockgroup;
	}

	public Object getBlockgroup(){
		return blockgroup;
	}

	public void setSrcName(String srcName){
		this.srcName = srcName;
	}

	public String getSrcName(){
		return srcName;
	}

	public void setMaintainer(Maintainer maintainer){
		this.maintainer = maintainer;
	}

	public Maintainer getMaintainer(){
		return maintainer;
	}

	public void setSrcDomain(String srcDomain){
		this.srcDomain = srcDomain;
	}

	public String getSrcDomain(){
		return srcDomain;
	}

	public void setTab(String tab){
		this.tab = tab;
	}

	public String getTab(){
		return tab;
	}

	public void setIsStackexchange(Object isStackexchange){
		this.isStackexchange = isStackexchange;
	}

	public Object getIsStackexchange(){
		return isStackexchange;
	}

	public void setId(String id){
		this.id = id;
	}

	public String getId(){
		return id;
	}

	public void setProductionState(String productionState){
		this.productionState = productionState;
	}

	public String getProductionState(){
		return productionState;
	}

	public void setSrcId(int srcId){
		this.srcId = srcId;
	}

	public int getSrcId(){
		return srcId;
	}

	public void setDesigner(Object designer){
		this.designer = designer;
	}

	public Object getDesigner(){
		return designer;
	}

	public void setDevMilestone(String devMilestone){
		this.devMilestone = devMilestone;
	}

	public String getDevMilestone(){
		return devMilestone;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setAttribution(Object attribution){
		this.attribution = attribution;
	}

	public Object getAttribution(){
		return attribution;
	}

	public void setSignalFrom(String signalFrom){
		this.signalFrom = signalFrom;
	}

	public String getSignalFrom(){
		return signalFrom;
	}

	public void setTopic(List<String> topic){
		this.topic = topic;
	}

	public List<String> getTopic(){
		return topic;
	}

	public void setProducer(Object producer){
		this.producer = producer;
	}

	public Object getProducer(){
		return producer;
	}

	public void setDeveloper(List<DeveloperItem> developer){
		this.developer = developer;
	}

	public List<DeveloperItem> getDeveloper(){
		return developer;
	}

	public void setCreatedDate(Object createdDate){
		this.createdDate = createdDate;
	}

	public Object getCreatedDate(){
		return createdDate;
	}

	public void setLiveDate(Object liveDate){
		this.liveDate = liveDate;
	}

	public Object getLiveDate(){
		return liveDate;
	}

	public void setSrcOptions(SrcOptions srcOptions){
		this.srcOptions = srcOptions;
	}

	public SrcOptions getSrcOptions(){
		return srcOptions;
	}

	public void setStatus(String status){
		this.status = status;
	}

	public String getStatus(){
		return status;
	}

	@Override
 	public String toString(){
		return 
			"Meta{" + 
			"src_url = '" + srcUrl + '\'' + 
			",repo = '" + repo + '\'' + 
			",perl_module = '" + perlModule + '\'' + 
			",example_query = '" + exampleQuery + '\'' + 
			",js_callback_name = '" + jsCallbackName + '\'' + 
			",dev_date = '" + devDate + '\'' + 
			",description = '" + description + '\'' + 
			",unsafe = '" + unsafe + '\'' + 
			",blockgroup = '" + blockgroup + '\'' + 
			",src_name = '" + srcName + '\'' + 
			",maintainer = '" + maintainer + '\'' + 
			",src_domain = '" + srcDomain + '\'' + 
			",tab = '" + tab + '\'' + 
			",is_stackexchange = '" + isStackexchange + '\'' + 
			",id = '" + id + '\'' + 
			",production_state = '" + productionState + '\'' + 
			",src_id = '" + srcId + '\'' + 
			",designer = '" + designer + '\'' + 
			",dev_milestone = '" + devMilestone + '\'' + 
			",name = '" + name + '\'' + 
			",attribution = '" + attribution + '\'' + 
			",signal_from = '" + signalFrom + '\'' + 
			",topic = '" + topic + '\'' + 
			",producer = '" + producer + '\'' + 
			",developer = '" + developer + '\'' + 
			",created_date = '" + createdDate + '\'' + 
			",live_date = '" + liveDate + '\'' + 
			",src_options = '" + srcOptions + '\'' + 
			",status = '" + status + '\'' + 
			"}";
		}
}