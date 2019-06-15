package com.example.demo.domain.primary;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = Course.COURSE)
public class Course implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	static final String COURSE = "course";

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer course_id;


    private int price;


    @NotEmpty(message = "User Name is required.")
    private String coursename;



    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "coach_id")
    private Coach coach;

    /**
     * 1銆佸叧绯荤淮鎶ょ锛岃礋璐ｅ瀵瑰鍏崇郴鐨勭粦瀹氬拰瑙ｉ櫎
     * 2銆丂JoinTable娉ㄨВ鐨刵ame灞炴�ф寚瀹氬叧鑱旇〃鐨勫悕瀛楋紝joinColumns鎸囧畾澶栭敭鐨勫悕瀛楋紝鍏宠仈鍒板叧绯荤淮鎶ょ(Customer)
     * 3銆乮nverseJoinColumns鎸囧畾澶栭敭鐨勫悕瀛楋紝瑕佸叧鑱旂殑鍏崇郴琚淮鎶ょ(Coach)
     * 4銆佸叾瀹炲彲浠ヤ笉浣跨敤@JoinTable娉ㄨВ锛岄粯璁ょ敓鎴愮殑鍏宠仈琛ㄥ悕绉颁负涓昏〃琛ㄥ悕+涓嬪垝绾�+浠庤〃琛ㄥ悕锛屽嵆琛ㄥ悕涓篊ustomer_Coach
     * 鍏宠仈鍒颁富琛ㄧ殑澶栭敭鍚嶏細涓昏〃鍚�+涓嬪垝绾�+涓昏〃涓殑涓婚敭鍒楀悕,鍗砪ustomer_id
     * 鍏宠仈鍒颁粠琛ㄧ殑澶栭敭鍚嶏細涓昏〃涓敤浜庡叧鑱旂殑灞炴�у悕+涓嬪垝绾�+浠庤〃鐨勪富閿垪鍚�,鍗砤coazh_id
     * 涓昏〃灏辨槸鍏崇郴缁存姢绔搴旂殑琛紝浠庤〃灏辨槸鍏崇郴琚淮鎶ょ瀵瑰簲鐨勮〃
     */
    @ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinTable(name = "course_customer",
            joinColumns = {@JoinColumn(name = "course_id", referencedColumnName = "course_id")},
            inverseJoinColumns = {@JoinColumn(name = "customer_id", referencedColumnName = "id")})
    private List<Customer> customers;


    public Integer getCourse_id() {
        return course_id;
    }

    public void setCourse_id(Integer course_id) {
        this.course_id = course_id;
    }

    public String getCoursename() {
        return coursename;
    }

    public void setCoursename(String coursename) {
        this.coursename = coursename;
    }

    public Coach getCoach() {
        return coach;
    }

    public void setCoach(Coach coach) {
        this.coach = coach;
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Course(){};
    public Course(String coursename,int price) {
        this.coursename = coursename;
        this.coach = new Coach();
        this.price = price;
        this.customers = new ArrayList<Customer>();
    }

    @Override
    public String toString() {
        return "Course{" +
                "course_id=" + course_id +
                "price=" + price +
                ", coursename='" + coursename + '\'' +
                ", coach=" + coach +
                ", customers=" + customers.size() +
                '}';
    }
}
