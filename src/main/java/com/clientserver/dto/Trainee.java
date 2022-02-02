

package com.clientserver.dto;

public class Trainee {
	private int traineeId;
	private int deptId;
	private int traineePersonId;
	private int trainerPersonId;
	private Person person;
	public int getTraineeId() {
		return traineeId;
	}
	public void setTraineeId(int traineeId) {
		this.traineeId = traineeId;
	}
	public int getDeptId() {
		return deptId;
	}
	public void setDeptId(int deptId) {
		this.deptId = deptId;
	}
	public int getTraineePersonId() {
		return traineePersonId;
	}
	public void setTraineePersonId(int traineePersonId) {
		this.traineePersonId = traineePersonId;
	}
	public int getTrainerPersonId() {
		return trainerPersonId;
	}
	public void setTrainerPersonId(int trainerPersonId) {
		this.trainerPersonId = trainerPersonId;
	}
	public Person getPerson() {
		return person;
	}
	public void setPerson(Person person) {
		this.person = person;
	}
	
	
}
