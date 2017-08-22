package com.sia;

public class BraveKnight implements Knight {
	private String name;
	private Quest quest;
	
	public BraveKnight(Quest quest) {
		this.setName("Unnamed");
		this.setQuest(quest);
	}
	
	public BraveKnight(String name, Quest quest) {
		this.setName(name);
		this.setQuest(quest);
	}
	
	@Override
	public void embarkOnQuest() {
		quest.embark();
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public Quest getQuest() {
		return quest;
	}

	public void setQuest(Quest quest) {
		this.quest = quest;
	}
	
}
