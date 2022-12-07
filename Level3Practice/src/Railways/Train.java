package Railways;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Train implements Serializable
{
	private int userId;
	private long pnr;
	private int trainNo;
	private String trainName;
	private String classType;
	private String date;
	private String from;
	private String to;
	private int seatNo;
	private String status;

	private String passengerName;
	private int age;
	private String sex;
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public long getPnr() {
		return pnr;
	}
	public void setPnr(long pnr) {
		this.pnr = pnr;
	}
	public int getTrainNo() {
		return trainNo;
	}
	public void setTrainNo(int trainNo) {
		this.trainNo = trainNo;
	}
	public String getTrainName() {
		return trainName;
	}
	public void setTrainName(String trainName) {
		this.trainName = trainName;
	}
	public String getClassType() {
		return classType;
	}
	public void setClassType(String classType) {
		this.classType = classType;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	public int getSeatNo() {
		return seatNo;
	}
	public void setSeatNo(int seatNo) {
		this.seatNo = seatNo;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getPassengerName() {
		return passengerName;
	}
	public void setPassengerName(String passengerName) {
		this.passengerName = passengerName;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	
	public String toString()
	{
		return "Train Details"
				+ "\nUserId: " + userId
				+ "\nPNR: " + pnr
				+ "\nTrain Name: " + trainName
				+ "\nClass: " + classType
				+ "\nDate: " + date
				+ "\nFrom: " + from
				+ "\nTo: " + to
				+ "\n\nSeat Number: " + seatNo
				+ "\nCurrent Status: " + status
				+ "\nPassenger Details"
				+ "\nPassenger Name: " + passengerName
				+ "\nAge: " + age
				+ "\nSex: " + sex;
	}
}
