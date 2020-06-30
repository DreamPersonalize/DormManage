package com.Model;

import java.sql.Date;


/*订单*/
public class Order {
	
	private int IDOrder;
	private String IDRoom;
	private String NickName;
	private String RealName;
	private String IDNumber;
	private Date TimeHousing;
	private int DayHousing;
	private int HaveBreakfast;
	private int AllPrice;
	private Date TimeOrder;
	private String TypeRoom;
	
	
	public int getIDOrder() {
		return IDOrder;
	}
	public void setIDOrder(int numOrder) {
		IDOrder = numOrder;
	}
	public String getIDRoom() {
		return IDRoom;
	}
	public void setIDRoom(String iDRoom) {
		IDRoom = iDRoom;
	}
	public String getNickName() {
		return NickName;
	}
	public void setNickName(String nickName) {
		NickName = nickName;
	}
	public String getRealName() {
		return RealName;
	}
	public void setRealName(String realName) {
		RealName = realName;
	}
	public String getIDNumber() {
		return IDNumber;
	}
	public void setIDNumber(String iDNumber) {
		IDNumber = iDNumber;
	}
	public Date getTimeHousing() {
		return TimeHousing;
	}
	public void setTimeHousing(Date date) {
		TimeHousing = date;
	}
	public int getDayHousing() {
		return DayHousing;
	}
	public void setDayHousing(int dayHousing) {
		DayHousing = dayHousing;
	}
	public int getHaveBreakfast() {
		return HaveBreakfast;
	}
	public void setHaveBreakfast(int haveBreakfast) {
		HaveBreakfast = haveBreakfast;
	}
	public int getAllPrice() {
		return AllPrice;
	}
	public void setAllPrice(int allprice) {
		AllPrice = allprice;
	}
	public Date getTimeOrder() {
		return TimeOrder;
	}
	public void setTimeOrder(Date timeOrder) {
		TimeOrder = timeOrder;
	}
	
	public String getTypeRoom() {
		return TypeRoom;
	}
	public void setTypeRoom(String typeRoom) {
		TypeRoom = typeRoom;
	}
	
	
	
}
