package Alumni.bo;

public class Add_bo {
	
	private int id;
	private String register_no;
	private String name;
	private String email;
	private String mob;
	private String aadhar;
	private String stream;
	private String course;
	private String join_year;
	private String passout_year;
	private String profession;
	private String gender;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getRegister_no() {
		return register_no;
	}
	public void setRegister_no(String register_no) {
		this.register_no = register_no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMob() {
		return mob;
	}
	public void setMob(String mob) {
		this.mob = mob;
	}
	public String getAadhar() {
		return aadhar;
	}
	public void setAadhar(String aadhar) {
		this.aadhar = aadhar;
	}
	public String getStream() {
		return stream;
	}
	public void setStream(String stream) {
		this.stream = stream;
	}
	public String getCourse() {
		return course;
	}
	public void setCourse(String course) {
		this.course = course;
	}
	public String getJoin_year() {
		return join_year;
	}
	public void setJoin_year(String join_year) {
		this.join_year = join_year;
	}
	public String getPassout_year() {
		return passout_year;
	}
	public void setPassout_year(String passout_year) {
		this.passout_year = passout_year;
	}
	public String getProfession() {
		return profession;
	}
	public void setProfession(String profession) {
		this.profession = profession;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	@Override
	public String toString() {
		return "Add_bo [id=" + id + ", register_no=" + register_no + ", name=" + name + ", email=" + email + ", mob="
				+ mob + ", aadhar=" + aadhar + ", stream=" + stream + ", course=" + course + ", join_year=" + join_year
				+ ", passout_year=" + passout_year + ", profession=" + profession + ", gender=" + gender + "]";
	}
	public Add_bo( String register_no, String name, String email, String mob, String aadhar, String stream,
			String course, String join_year, String passout_year, String profession, String gender) {
		super();
		this.id = id;
		this.register_no = register_no;
		this.name = name;
		this.email = email;
		this.mob = mob;
		this.aadhar = aadhar;
		this.stream = stream;
		this.course = course;
		this.join_year = join_year;
		this.passout_year = passout_year;
		this.profession = profession;
		this.gender = gender;
	}
	public Add_bo() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
	
	
	
	

	
	
