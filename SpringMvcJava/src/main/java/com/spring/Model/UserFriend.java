
package com.spring.Model;

public class UserFriend{
	     private String userid;
		private String email;
		private String name;
		private String place;
		private byte[] photo;
		private String encode;
		private int age;
		
		public String getEncode() {
			return encode;
		}
		public void setEncode(String encode) {
			this.encode = encode;
		}
		public int getAge() {
			return age;
		}
		public void setAge(int age) {
			this.age = age;
		}
		public UserFriend(String n)
		{
			this.name=n;
		}
		public UserFriend(String n,String e,String p,String en)
		{
			this.name=n;
			this.email=e;
			this.place=p;
			this.encode=en;
		}
		public UserFriend(String i,String m,String n)
		{
			this.userid=i;
			this.email=m;
			this.name=n;
			
		}
		
		public UserFriend(String e,String n )
		{
			this.email=e;
			this.name=n;
		}
		public UserFriend( byte[] photo)
		{
			this.photo=photo;
		}
		public UserFriend() {
			// TODO Auto-generated constructor stub
		}
		public String getUserid() {
			return userid;
		}
		
		public byte[] getPhoto() {
			return photo;
		}
		public void setPhoto(byte[] photo) {
			this.photo = photo;
		}
		public void setUserid(String userid) {
			this.userid = userid;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public void setName(String name) {
			this.name = name;
		}
		public void setPlace(String place) {
			this.place = place;
		}
		public String getEmail() 
		{ 
			return email;
		}
	    public String getName() 
	    {
	    	return name; 
	    }
	    public String getPlace() 
	    {
	    	return place; 
	    }
	 

		
		
}
