@Entity
public class User{
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
	
	private String login;
	
	
}