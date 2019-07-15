package javadomexample;

public class Student 
{
	private Integer id;
	private String firstName;
	private String lastName;
	private String mail;

        public Student() {
        }

        public Student(Integer id, String firstName, String lastName, String mail) {
            this.id = id;
            this.firstName = firstName;
            this.lastName = lastName;
            this.mail = mail;
        }

	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}
    
    @Override
	public String toString() {
		return "Student [id=" + id + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", mail=" + mail + "] \n";
	}
}
