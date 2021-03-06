package studyo.authentication;

public class GoogleUser {

	private String userId;
	private String email;
	private boolean emailVerified;
	private String name;
	private String pictureUrl;
	private String locale;
	private String familyName;
	private String givenName;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public boolean isEmailVerified() {
		return emailVerified;
	}

	public void setEmailVerified(boolean emailVerified) {
		this.emailVerified = emailVerified;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPictureUrl() {
		return pictureUrl;
	}

	public void setPictureUrl(String pictureUrl) {
		this.pictureUrl = pictureUrl;
	}

	public String getLocale() {
		return locale;
	}

	public void setLocale(String locale) {
		this.locale = locale;
	}

	public String getFamilyName() {
		return familyName;
	}

	public void setFamilyName(String familyName) {
		this.familyName = familyName;
	}

	public String getGivenName() {
		return givenName;
	}

	public void setGivenName(String givenName) {
		this.givenName = givenName;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("GoogleUser [userId=").append(userId).append(", email=").append(email).append(", emailVerified=")
				.append(emailVerified).append(", name=").append(name).append(", pictureUrl=").append(pictureUrl)
				.append(", locale=").append(locale).append(", familyName=").append(familyName).append(", givenName=")
				.append(givenName).append("]");
		return builder.toString();
	}

}
