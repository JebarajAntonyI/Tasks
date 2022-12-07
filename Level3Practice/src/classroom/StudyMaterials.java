package classroom;

public class StudyMaterials 
{
	private int id;
	private String faculty;
	private String email;
	private String materials;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFaculty() {
		return faculty;
	}
	public void setFaculty(String faculty) {
		this.faculty = faculty;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String name) {
		this.email = name;
	}
	public String getMaterials() {
		return materials;
	}
	public void setMaterials(String materials) {
		this.materials = materials;
	}
	
	@Override
	public String toString() {
		return "StudyMaterials [id=" + id + ", faculty=" + faculty + ", email=" + email + ", materials=" + materials
				+ "]";
	}
}
