

import java.awt.GridLayout;
import java.awt.*;
import java.awt.event.*;
//import java.awt.event.ActionListener;
import java.sql.*;

import javax.swing.*;
import java.util.ArrayList;
//import javax.swing.JFrame;
//import javax.swing.JPanel;
//import javax.swing.JScrollPane;
//import javax.swing.JTextArea;
class SubFrame extends JFrame implements ActionListener{

    public SubFrame(String S){
        super(S);
        setSize(500,100);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JButton bt = new JButton(S+" 번호(아이디)가 잘못된 입력입니다. 다시입력하세요.");
        add(bt);
        bt.addActionListener(this);
        setLocation(200, 0);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        dispose();
    }
}


//------------------------------------------------------------학생 시간표
class Sschedule extends JFrame implements ActionListener{
	
	Container Main = getContentPane();

	JPanel N,C,W;
	
	JTextArea[] txt;
	
  public Sschedule(String S){
      super(S);
      setSize(600,300);
      layInit();
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setLocation(200, 0);
      setVisible(true);
  }
  
  public void layInit() {
  	Main.setLayout(new BorderLayout());
  	
  	C = new JPanel();
  	N = new JPanel();
  	W = new JPanel();
  	
  	C.setLayout(new GridLayout(8,5));
  	N.setLayout(new GridLayout(1,6));
  	W.setLayout(new GridLayout(8,1));
  	
  	
  	Main.add("Center",C);
  	Main.add("North",N);
  	Main.add("West",W);
  	
  	N.add(new JTextArea("교시"));
  	N.add(new JTextArea("월"));
  	N.add(new JTextArea("화"));
  	N.add(new JTextArea("수"));
  	N.add(new JTextArea("목"));
  	N.add(new JTextArea("금"));
  	//무기화학 목 3 2
  	
  	String data = getTitle();
  	String []SplitData = data.split(" "); // 0~3 까지 1 set 4 ~ 7까지 2 set 
  	
  	/*
  	for(int i=0;i<SplitData.length;i++) {
  		System.out.println(SplitData[i]);
  		System.out.println(i);
  	}*/
  	
  	//SplitData[1] == "무기화학"
  //SplitData[2] == "목"
  //SplitData[3] == "3"
  //SplitData[4] == "2"
  	int[] list = new int[999];
  	String[] list2 = new String[999];

  	
  	int arrCnt=0;
  	int cnt = 2;
  	while(true) {
  		if(cnt > SplitData.length){
  			break;
  		}
		int x=0;
		int y,z;
		
		
	
		if(SplitData[cnt].equals("월")) {
			x=0;
		}
		else if(SplitData[cnt].equals("화")) {
			x=1;
		}
		else if(SplitData[cnt].equals("수")) {
			x=2;
		}
		else if(SplitData[cnt].equals("목")) {
			x=3;
		}
		else if(SplitData[cnt].equals("금")) {
			x=4;
		}
		
		y=Integer.parseInt(SplitData[cnt+1]);
		z=Integer.parseInt(SplitData[cnt+2]);
		
		
		for(int i=y;i<y+z;i++) {
			
			
			list[arrCnt] = (i-1)*5+x;
			list2[arrCnt] = SplitData[cnt-1];

			arrCnt++;
			
		}
		cnt = cnt+4;
  	}
  	
  	//list.get(0) == 첫번째 좌표.
  	
  	
  	for(int i=0;i<40;i++) {
  		int flag=0;
  		for(int j=0;j<arrCnt+1;j++) {
  			if(list[j]==i) {
  				flag=1;
  	  		  	C.add(new JTextField(list2[j]));
  				break;
  			}
  		}
  		if(flag==1) {
;
  		}
  		else {
  		  	C.add(new JTextField(" "));		
  		}
  		
  	}
  	
  	for(int i=0;i<8;i++) {
  		W.add(new JTextArea((i+1)+" 교시"));
  	}
  	
  	
  	
  }

  @Override
  public void actionPerformed(ActionEvent e) {
      // TODO Auto-generated method stub
      dispose();
  }
}

//------------------------------------------------------------교수 시간표
class Pschedule extends JFrame implements ActionListener{
	
	Container Main = getContentPane();

	JPanel N,C,W;
	
	JTextArea[] txt;
	
    public Pschedule(String S){
        super(S);
        setSize(600,300);
        layInit();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocation(200, 0);
        setVisible(true);
    }
    
    public void layInit() {
    	Main.setLayout(new BorderLayout());
    	
    	C = new JPanel();
    	N = new JPanel();
    	W = new JPanel();
    	
    	C.setLayout(new GridLayout(8,5));
    	N.setLayout(new GridLayout(1,6));
    	W.setLayout(new GridLayout(8,1));
    	
    	
    	Main.add("Center",C);
    	Main.add("North",N);
    	Main.add("West",W);
    	
    	N.add(new JTextArea("교시"));
    	N.add(new JTextArea("월"));
    	N.add(new JTextArea("화"));
    	N.add(new JTextArea("수"));
    	N.add(new JTextArea("목"));
    	N.add(new JTextArea("금"));
    	
    	//무기화학 목 3 2
      	
      	String data = getTitle();
      	String []SplitData = data.split(" "); // 0~3 까지 1 set 4 ~ 7까지 2 set 
      	
      	/*
      	for(int i=0;i<SplitData.length;i++) {
      		System.out.println(SplitData[i]);
      		System.out.println(i);
      	}*/
      	
      	//SplitData[1] == "무기화학"
      //SplitData[2] == "목"
      //SplitData[3] == "3"
      //SplitData[4] == "2"
      	int[] list = new int[999];
      	String[] list2 = new String[999];

      	
      	int arrCnt=0;
      	int cnt = 2;
      	while(true) {
      		if(cnt > SplitData.length){
      			break;
      		}
    		int x=0;
    		int y,z;
    		
    		
    	
    		if(SplitData[cnt].equals("월")) {
    			x=0;
    		}
    		else if(SplitData[cnt].equals("화")) {
    			x=1;
    		}
    		else if(SplitData[cnt].equals("수")) {
    			x=2;
    		}
    		else if(SplitData[cnt].equals("목")) {
    			x=3;
    		}
    		else if(SplitData[cnt].equals("금")) {
    			x=4;
    		}
    		
    		y=Integer.parseInt(SplitData[cnt+1]);
    		z=Integer.parseInt(SplitData[cnt+2]);
    		
    		
    		for(int i=y;i<y+z;i++) {
    			
    			
    			list[arrCnt] = (i-1)*5+x;
    			list2[arrCnt] = SplitData[cnt-1];

    			arrCnt++;
    			
    		}
    		cnt = cnt+4;
      	}
    
      	//list.get(0) == 첫번째 좌표.
      	
      	
      	for(int i=0;i<40;i++) {
      		int flag=0;
      		for(int j=0;j<arrCnt+1;j++) {
      			if(list[j]==i) {
      				flag=1;
      	  		  	C.add(new JTextField(list2[j]));
      				break;
      			}
      		}
      		if(flag==1) {
    ;
      		}
      		else {
      		  	C.add(new JTextField(" "));		
      		}
      		
      	}
      	
      	for(int i=0;i<8;i++) {
      		W.add(new JTextArea((i+1)+" 교시"));
      	}
    	
    	
    	
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        dispose();
    }
}



//----------------------------------------------------------------------------------------------------------------관리자 Frame
class RFrame extends JFrame implements ActionListener{
	
	   static Connection con;
	   Statement stmt;
	   ResultSet rs;
	   String Driver = "";
	   String url = "jdbc:mysql://localhost:3306/madang?&serverTimezone=Asia/Seoul&useSSL=false";
	   String userid = "madang";
	   String pwd = "madang";

	
	
	Container a = getContentPane();
	   JTextField initF;
	   JTextArea txtResult, txtStatus;
	   
	JPanel N;
	JButton BtnInit;
	JButton BtnIDU;
	JButton ShowTable;
	JButton Cancel;
	
public RFrame(String S){
  super(S);
  layInit();
  conDB();
  setVisible(true);
  setTitle(S);

  setBounds(200, 200, 800, 500); //가로위치,세로위치,가로길이,세로길이
  setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
}
public void layInit() {
	txtResult = new JTextArea();
	txtStatus = new JTextArea(5,30);
	
	N = new JPanel();
	a.setLayout(new BorderLayout());
	initF = new JTextField(20);
	
	BtnInit = new JButton("DB초기화");
	BtnIDU = new JButton("입력/삭제/수정");
	ShowTable = new JButton("모든테이블 출력");
	Cancel = new JButton("입력취소");
	
	
	      JScrollPane scrollPane = new JScrollPane(txtResult);
	      JScrollPane scrollPane2 = new JScrollPane(txtStatus);
	      
	      
	      JPanel N1 = new JPanel();
	      JPanel N2 = new JPanel();
	      JPanel N3 = new JPanel();
	      
	      
	      	N1.add( new JLabel("환영합니다! "+getTitle()+"님"));
	    	N3.add(new JLabel("조건식 : "));
	    	N3.add(initF);
	    	  N3.add(BtnIDU);
	    	  N3.add(Cancel);
	      N2.add(BtnInit);
	      N2.add(ShowTable);
	      
	    	  
	      N.setLayout(new GridLayout(3,1));
	      
	      N.add(N1);
	      N.add(N2);
	      N.add(N3);
	      
	      
	
	
	
	      a.add("North",N);
	      txtResult.setEditable(false);
	      txtStatus.setEditable(false);
	      
	      a.add("Center", scrollPane);
	      a.add("South", scrollPane2);  
	      
	      
	      
	      BtnInit.addActionListener(this);
	      BtnIDU.addActionListener(this);
	      Cancel.addActionListener(this);
	      ShowTable.addActionListener(this);
	      
	
}
public void conDB() {
  try {
     Class.forName("com.mysql.cj.jdbc.Driver");
     //System.out.println("드라이버 로드 성공");
     txtStatus.append("드라이버 로드 성공...\n");
  } catch (ClassNotFoundException e) {
     e.printStackTrace();
  }
  
  try { /* 데이터베이스를 연결하는 과정 */
      //System.out.println("데이터베이스 연결 준비...");
	  txtStatus.append("데이터베이스 연결 준비...\n");
      con = DriverManager.getConnection(url, userid, pwd);
      //System.out.println("데이터베이스 연결 성공");
      txtStatus.append("데이터베이스 연결 성공...\n");
   } catch (SQLException e1) {
      e1.printStackTrace();
   }
}



@Override
public void actionPerformed(ActionEvent e) {
	 try {
         stmt = con.createStatement();
         
         //검색
         if (e.getSource() == BtnInit) {

             String str = "SET FOREIGN_KEY_CHECKS=0;\r\n"
                   + "drop table if exists belong,club,course,course_history,dept,dept_course,join_club,professor,student,tuition_history;";                           
             
             String[] arr = str.split("\n"); 
             for(int i=0;i<=1;i++) {
                stmt.executeUpdate(arr[i]);
             }
             
             
             
             String[] str1 = new String[11];
             String[] str2 = new String[11];
             
             int i=0;
             
             str1[i] ="CREATE TABLE IF NOT EXISTS `madang`.`professor` (\r\n"
                   + "`professorid` INT NOT NULL,\r\n"
                   + "  `name` CHAR(20) NULL,\r\n"
                   + "  `address` VARCHAR(45) NULL,\r\n"
                   + "  `phone_number` VARCHAR(80) NULL,\r\n"
                   + "  `e-mail` VARCHAR(80) NULL,\r\n"
                   + "  PRIMARY KEY (`professorid`))\r\n"
                   + "ENGINE = InnoDB;";
             stmt.executeUpdate(str1[i]);   i++;
             
             str1[i] ="CREATE TABLE IF NOT EXISTS `madang`.`Dept` (\r\n"
                   + "  `deptid` INT NOT NULL,\r\n"
                   + "  `name` CHAR(20) NULL,\r\n"
                   + "  `phone_number` VARCHAR(45) NULL,\r\n"
                   + "  `office` VARCHAR(45) NULL,\r\n"
                   + "  `professor_professorid` INT NOT NULL,\r\n"
                   + "  PRIMARY KEY (`deptid`),\r\n"
                   + "  INDEX `fk_Dept_professor1_idx` (`professor_professorid` ASC) VISIBLE,\r\n"
                   + "  CONSTRAINT `fk_Dept_professor1`\r\n"
                   + "    FOREIGN KEY (`professor_professorid`)\r\n"
                   + "    REFERENCES `madang`.`professor` (`professorid`)\r\n"
                   + "    ON DELETE NO ACTION\r\n"
                   + "    ON UPDATE NO ACTION)\r\n"
                   + "ENGINE = InnoDB;";
             stmt.executeUpdate(str1[i]);   i++;
             
             str1[i] ="CREATE TABLE IF NOT EXISTS `madang`.`tuition_history` (\r\n"
                   + "  `studentid` INT NULL,\r\n"
                   + "  `payment_year` INT NULL,\r\n"
                   + "  `payment_semester` INT NULL,\r\n"
                   + "  `total_tuition` INT NULL,\r\n"
                   + "  `total_payment` INT NULL,\r\n"
                   + "  `last_paymentday` DATE NULL,\r\n"
                   + "  `tuition_account` VARCHAR(45) NOT NULL,\r\n"
                   + "  PRIMARY KEY (`tuition_account`))\r\n"
                   + "ENGINE = InnoDB;";
             stmt.executeUpdate(str1[i]);   i++;
             
             str1[i] ="CREATE TABLE IF NOT EXISTS `madang`.`student` (\r\n"
                   + "  `studentid` INT NOT NULL,\r\n"
                   + "  `name` CHAR(20) NULL,\r\n"
                   + "  `address` VARCHAR(45) NULL,\r\n"
                   + "  `phone_number` VARCHAR(45) NULL,\r\n"
                   + "  `e-mail` VARCHAR(80) NULL,\r\n"
                   + "  `year` INT NULL,\r\n"
                   + "  `semester` INT NULL,\r\n"
                   + "  `professorid` INT NOT NULL,\r\n"
                   + "  `minor_id` INT NULL,\r\n"
                   + "  `tuition history_tuition_account` VARCHAR(45) NOT NULL,\r\n"
                   + "  `major_id` INT NOT NULL,\r\n"
                   + "  PRIMARY KEY (`studentid`),\r\n"
                   + "  INDEX `fk_student_professor_idx` (`professorid` ASC) VISIBLE,\r\n"
                   + "  INDEX `fk_student_Dept1_idx` (`minor_id` ASC) VISIBLE,\r\n"
                   + "  INDEX `fk_student_tuition history1_idx` (`tuition history_tuition_account` ASC) VISIBLE,\r\n"
                   + "  INDEX `fk_student_Dept2_idx` (`major_id` ASC) VISIBLE,\r\n"
                   + "  CONSTRAINT `fk_student_professor`\r\n"
                   + "    FOREIGN KEY (`professorid`)\r\n"
                   + "    REFERENCES `madang`.`professor` (`professorid`)\r\n"
                   + "    ON DELETE NO ACTION\r\n"
                   + "    ON UPDATE NO ACTION,\r\n"
                   + "  CONSTRAINT `fk_student_Dept1`\r\n"
                   + "    FOREIGN KEY (`minor_id`)\r\n"
                   + "    REFERENCES `madang`.`Dept` (`deptid`)\r\n"
                   + "    ON DELETE NO ACTION\r\n"
                   + "    ON UPDATE NO ACTION,\r\n"
                   + "  CONSTRAINT `fk_student_tuition history1`\r\n"
                   + "    FOREIGN KEY (`tuition history_tuition_account`)\r\n"
                   + "    REFERENCES `madang`.`tuition_history` (`tuition_account`)\r\n"
                   + "    ON DELETE NO ACTION\r\n"
                   + "    ON UPDATE NO ACTION,\r\n"
                   + "  CONSTRAINT `fk_student_Dept2`\r\n"
                   + "    FOREIGN KEY (`major_id`)\r\n"
                   + "    REFERENCES `madang`.`Dept` (`deptid`)\r\n"
                   + "    ON DELETE NO ACTION\r\n"
                   + "    ON UPDATE NO ACTION)\r\n"
                   + "ENGINE = InnoDB;";
             stmt.executeUpdate(str1[i]);   i++;
             
             str1[i] ="CREATE TABLE IF NOT EXISTS `madang`.`course` (\r\n"
                   + "  `courseid` INT NOT NULL,\r\n"
                   + "  `divided_class` INT NULL,\r\n"
                   + "  `name` CHAR(20) NULL,\r\n"
                   + "  `day` CHAR(20) NULL,\r\n"
                   + "  `start_class` VARCHAR(45) NULL,\r\n"
                   + "  `get_grade` INT NULL,\r\n"
                   + "  `time` INT NULL,\r\n"
                   + "  `dept` CHAR(20) NULL,\r\n"
                   + "  `office` VARCHAR(45) NULL,\r\n"
                   + "  PRIMARY KEY (`courseid`))\r\n"
                   + "ENGINE = InnoDB;";
              stmt.executeUpdate(str1[i]);   i++;
              
             str1[i] ="CREATE TABLE IF NOT EXISTS `madang`.`club` (\r\n"
                   + "  `clubid` INT NOT NULL,\r\n"
                   + "  `name` CHAR(20) NULL,\r\n"
                   + "  `room` VARCHAR(45) NULL,\r\n"
                   + "  `president` INT NOT NULL,\r\n"
                   + "  `professor_professorid` INT NOT NULL,\r\n"
                   + "  PRIMARY KEY (`clubid`),\r\n"
                   + "  INDEX `fk_club_student1_idx` (`president` ASC) VISIBLE,\r\n"
                   + "  INDEX `fk_club_professor1_idx` (`professor_professorid` ASC) VISIBLE,\r\n"
                   + "  CONSTRAINT `fk_club_student1`\r\n"
                   + "    FOREIGN KEY (`president`)\r\n"
                   + "    REFERENCES `madang`.`student` (`studentid`)\r\n"
                   + "    ON DELETE NO ACTION\r\n"
                   + "    ON UPDATE NO ACTION,\r\n"
                   + "  CONSTRAINT `fk_club_professor1`\r\n"
                   + "    FOREIGN KEY (`professor_professorid`)\r\n"
                   + "    REFERENCES `madang`.`professor` (`professorid`)\r\n"
                   + "    ON DELETE NO ACTION\r\n"
                   + "    ON UPDATE NO ACTION)\r\n"
                   + "ENGINE = InnoDB;";
              stmt.executeUpdate(str1[i]);   i++;

             str1[i] ="CREATE TABLE IF NOT EXISTS `madang`.`join_club` (\r\n"
                   + "  `number` INT NOT NULL,\r\n"
                   + "  `club_clubid` INT NOT NULL,\r\n"
                   + "  `student_studentid` INT NOT NULL,\r\n"
                   + "  INDEX `fk_join_club_club1_idx` (`club_clubid` ASC) VISIBLE,\r\n"
                   + "  PRIMARY KEY (`number`),\r\n"
                   + "  INDEX `fk_join_club_student1_idx` (`student_studentid` ASC) VISIBLE,\r\n"
                   + "  CONSTRAINT `fk_join_club_club1`\r\n"
                   + "    FOREIGN KEY (`club_clubid`)\r\n"
                   + "    REFERENCES `madang`.`club` (`clubid`)\r\n"
                   + "    ON DELETE NO ACTION\r\n"
                   + "    ON UPDATE NO ACTION,\r\n"
                   + "  CONSTRAINT `fk_join_club_student1`\r\n"
                   + "    FOREIGN KEY (`student_studentid`)\r\n"
                   + "    REFERENCES `madang`.`student` (`studentid`)\r\n"
                   + "    ON DELETE NO ACTION\r\n"
                   + "    ON UPDATE NO ACTION)\r\n"
                   + "ENGINE = InnoDB;\r\n"
                   + "";
              stmt.executeUpdate(str1[i]);   i++;
              
             str1[i] ="CREATE TABLE IF NOT EXISTS `madang`.`course_history` (\r\n"
                   + "  `number` INT NOT NULL,\r\n"
                   + "  `attendance_score` INT NULL,\r\n"
                   + "  `midterm_score` INT NULL,\r\n"
                   + "  `final_score` INT NULL,\r\n"
                   + "  `etc_score` INT NULL,\r\n"
                   + "  `total_score` INT NULL,\r\n"
                   + "  `average_score` CHAR(2) NULL,\r\n"
                   + "  `student_studentid` INT NOT NULL,\r\n"
                   + "  `professor_professorid` INT NOT NULL,\r\n"
                   + "  `course_courseid` INT NOT NULL,\r\n"
                   + "  `year` INT NULL,\r\n"
                   + "  `semester` INT NULL,\r\n"
                   + "  `get_grade` INT NULL,\r\n"
                   + "  `new_insert` VARCHAR(45) NULL,\r\n"
                   + "  PRIMARY KEY (`number`),\r\n"
                   + "  INDEX `fk_course_history_student1_idx` (`student_studentid` ASC) VISIBLE,\r\n"
                   + "  INDEX `fk_course_history_professor1_idx` (`professor_professorid` ASC) VISIBLE,\r\n"
                   + "  INDEX `fk_course_history_course1_idx` (`course_courseid` ASC) VISIBLE,\r\n"
                   + "  CONSTRAINT `fk_course_history_student1`\r\n"
                   + "    FOREIGN KEY (`student_studentid`)\r\n"
                   + "    REFERENCES `madang`.`student` (`studentid`)\r\n"
                   + "    ON DELETE NO ACTION\r\n"
                   + "    ON UPDATE NO ACTION,\r\n"
                   + "  CONSTRAINT `fk_course_history_professor1`\r\n"
                   + "    FOREIGN KEY (`professor_professorid`)\r\n"
                   + "    REFERENCES `madang`.`professor` (`professorid`)\r\n"
                   + "    ON DELETE NO ACTION\r\n"
                   + "    ON UPDATE NO ACTION,\r\n"
                   + "  CONSTRAINT `fk_course_history_course1`\r\n"
                   + "    FOREIGN KEY (`course_courseid`)\r\n"
                   + "    REFERENCES `madang`.`course` (`courseid`)\r\n"
                   + "    ON DELETE NO ACTION\r\n"
                   + "    ON UPDATE NO ACTION)\r\n"
                   + "ENGINE = InnoDB;";
              stmt.executeUpdate(str1[i]);   i++;
              
             str1[i] ="CREATE TABLE IF NOT EXISTS `madang`.`belong` (\r\n"
                   + "  `number` INT NOT NULL,\r\n"
                   + "  `Dept_deptid` INT NOT NULL,\r\n"
                   + "  `professor_professorid` INT NOT NULL,\r\n"
                   + "  PRIMARY KEY (`number`),\r\n"
                   + "  INDEX `fk_belong_Dept1_idx` (`Dept_deptid` ASC) VISIBLE,\r\n"
                   + "  INDEX `fk_belong_professor1_idx` (`professor_professorid` ASC) VISIBLE,\r\n"
                   + "  CONSTRAINT `fk_belong_Dept1`\r\n"
                   + "    FOREIGN KEY (`Dept_deptid`)\r\n"
                   + "    REFERENCES `madang`.`Dept` (`deptid`)\r\n"
                   + "    ON DELETE NO ACTION\r\n"
                   + "    ON UPDATE NO ACTION,\r\n"
                   + "  CONSTRAINT `fk_belong_professor1`\r\n"
                   + "    FOREIGN KEY (`professor_professorid`)\r\n"
                   + "    REFERENCES `madang`.`professor` (`professorid`)\r\n"
                   + "    ON DELETE NO ACTION\r\n"
                   + "    ON UPDATE NO ACTION)\r\n"
                   + "ENGINE = InnoDB;";
              stmt.executeUpdate(str1[i]);   i++;
              
             str1[i] ="CREATE TABLE IF NOT EXISTS `madang`.`dept_course` (\r\n"
                   + "  `number` INT NOT NULL,\r\n"
                   + "  `Dept_deptid` INT NOT NULL,\r\n"
                   + "  `course_courseid` INT NOT NULL,\r\n"
                   + "  PRIMARY KEY (`number`),\r\n"
                   + "  INDEX `fk_dept_course_Dept1_idx` (`Dept_deptid` ASC) VISIBLE,\r\n"
                   + "  INDEX `fk_dept_course_course1_idx` (`course_courseid` ASC) VISIBLE,\r\n"
                   + "  CONSTRAINT `fk_dept_course_Dept1`\r\n"
                   + "    FOREIGN KEY (`Dept_deptid`)\r\n"
                   + "    REFERENCES `madang`.`Dept` (`deptid`)\r\n"
                   + "    ON DELETE NO ACTION\r\n"
                   + "    ON UPDATE NO ACTION,\r\n"
                   + "  CONSTRAINT `fk_dept_course_course1`\r\n"
                   + "    FOREIGN KEY (`course_courseid`)\r\n"
                   + "    REFERENCES `madang`.`course` (`courseid`)\r\n"
                   + "    ON DELETE NO ACTION\r\n"
                   + "    ON UPDATE NO ACTION)\r\n"
                   + "ENGINE = InnoDB";
              stmt.executeUpdate(str1[i]);   i++;
             
             i=0;
             str2[i] ="INSERT INTO `madang`.`student`\r\n"
                   + "(`studentid`,`name`,`address`,`phone_number`,`e-mail`,`year`,`semester`,`professorid`,`minor_id`,`tuition history_tuition_account`,`major_id`)\r\n"
                   + "VALUES\r\n"
                   + "(20010989,'홍진수','서울 강남구 강남대로 494 2층','010-8288-0626','odio.Nam.interdum@dictumaugue.org',2,1,64010989,12,'706728-9483',1),\r\n"
                   + "(20010378,'강훈','서울 용산구 이촌로65가길 66','010-9954-1441','habitant.morbi@convallisconvallisdolor.org',2,1,65010378,13,'405938-7532',2),\r\n"
                   + "(20010962,'홍현표','서울 종로구 대명1길 10','010-5622-7216','pede.sagittis.augue@pretium.ca',2,1,66010962,14,'692512-0120',3),\r\n"
                   + "(20010968,'권세현','서울 중구 수표로 48-3','010-3840-6939','Vivamus.molestie@mauriserateget.co.uk',2,1,66010968,15,'605837-0419',4),\r\n"
                   + "(20011084,'김길환','서울 용산구 신흥로 37','010-6245-5022','fringilla.est.Mauris@dictumProineget.com',2,1,66011084,16,'205314-7290',5),\r\n"
                   + "(20012004,'김다영','경기 수원시 영통구 산남로 7 1층','010-4805-3225','per@nec.ca',2,1,66012004,17,'823682-0455',6),\r\n"
                   + "(20010681,'김재식','경기 군포시 군포로741번길 4 1층','010-7369-7167','ultricies.ornare@sem.com',2,1,67010681,18,'415767-1241',7),\r\n"
                   + "(20011005,'이동욱','경기 화성시 삼성1로 332-10','010-7802-8030','ipsum.primis.in@Duiscursusdiam.co.uk',2,1,67011005,19,'646996-0279',8),\r\n"
                   + "(20011023,'박건우','경기도 김포시 걸포2로 1(걸포동)','010-5382-7371','litora.torquent@a.com',2,1,67011023,20,'908524-8400',9),\r\n"
                   + "(20011466,'박기태','전라남도 영광군 영광읍 백수로18길 15-16','010-9920-5436','fringilla.est@aceleifendvitae.com',2,1,67011466,21,'196137-9425',10),\r\n"
                   + "(20011478,'최진수','경기도 가평군 조종면 연인산로 45-262','010-5952-2709','Maecenas@erosProin.net',2,1,67011478,22,'327569-4671',11),\r\n"
                   + "(20011480,'최선용','경기도 가평군 조종면 연인산로150번길 53-38','010-8223-3882','nostra.per.inceptos@nonsollicitudin.com',2,1,67011480,23,'242515-7845',12),\r\n"
                   + "(20011501,'홍수민','경기도 이천시 부발읍 경충대로2313번길 40-1(엣지빌)','010-9398-8822','tincidunt.Donec@natoque.edu',2,1,67011501,24,'972877-8458',13),\r\n"
                   + "(20011502,'홍의표','부산광역시 동래구 금정마을로 78-8(온천동, 금정빌라)','010-3394-8800','aliquet.lobortis@maurisSuspendisse.ca',2,1,68011481,25,'777251-5321',14),\r\n"
                   + "(21011550,'우은결','부산광역시 동래구 금정마을로74번길 8-2(온천동, 해동그린빌라)','010-4745-0531','rutrum.lorem.ac@nuncIn.net',1,1,68011509,null,'112952-8772',15),\r\n"
                   + "(21011554,'은혜인','경기도 부천시 중동로 2(송내동)','010-4821-1835','tellus@lorem.com',1,1,68011515,null,'455331-6250',16),\r\n"
                   + "(21011571,'윤예리','경기도 부천시 중동로 34(송내동, 로얄아파트)','010-9719-7644','erat.volutpat.Nulla@velitegestaslacinia.ca',1,1,69011572,null,'466465-3468',17),\r\n"
                   + "(21011572,'윤세빈','경기도 고양시 일산동구 무궁화로 7-45(장항동)','010-2182-7982','Donec.consectetuer.mauris@risusa.edu',1,1,69011579,null,'389152-7586',18),\r\n"
                   + "(21011579,'이우상','경기도 고양시 일산동구 무궁화로 8-19(장항동)','010-6610-0121','dolor@pedesagittis.org',1,1,69011580,null,'413876-2291',19),\r\n"
                   + "(21011580,'이종민','서울특별시 송파구 성남대로 1541-59(장지동)','010-1790-8917','tincidunt.nunc@Aeneansed.com',1,1,69013123,null,'197818-3398',20),\r\n"
                   + "(21013123,'전승원','경기도 성남시 분당구 성남대로 34(구미동)','010-3556-5021','consectetuer.euismod.est@estvitae.com',1,1,69013132,null,'424669-2232',21),\r\n"
                   + "(21013132,'조형준','경기도 남양주시 호평로 6(호평동)','010-3481-4214','Proin@etmagnisdis.co.uk',1,1,69013133,null,'704758-1165',22),\r\n"
                   + "(21013133,'박윤환','경기도 남양주시 호평로 18-13(호평동)','010-3087-0782','Maecenas@placeratCrasdictum.co.uk',1,1,69013136,null,'078084-2704',23),\r\n"
                   + "(21013136,'최병채','경기도 평택시 비전5로 7-1(비전동)','010-8131-0158','tortor@Sedmolestie.com',1,1,70011676,null,'927483-6858',24),\r\n"
                   + "(21011676,'윤혜성','경기도 평택시 비전5로 7-2(비전동)','010-5063-6516','vel.sapien@maurisutmi.edu',1,1,71030008,null,'457193-6105',25);";
              stmt.executeUpdate(str2[i]);   i++;
              
             str2[i] ="INSERT INTO `madang`.`club`\r\n"
                   + "(`clubid`,`name`,`room`,`president`,`professor_professorid`)\r\n"
                   + "VALUES\r\n"
                   + "(1,'늘헴코러스', '학501',20010989,64010989),\r\n"
                   + "(2,'더블랙', '학620',20010378,65010378),\r\n"
                   + "(3,'소리더하기', '학B208',20010962,66010962),\r\n"
                   + "(4,'소울트레인', '학B201',20010968,66010968),\r\n"
                   + "(5,'세종극회', '학526',20011084,66011084),\r\n"
                   + "(6,'인트로', '학B202',20012004,66012004),\r\n"
                   + "(7,'터벌림', '학621',20010681,67010681),\r\n"
                   + "(8,'페이지7', '학605',20011005,67011005),\r\n"
                   + "(9,'한울림', '학514',20011023,67011023),\r\n"
                   + "(10,'러쉬', '학510',20011466,67011466),\r\n"
                   + "(11,'발파람', '학516',20011478,67011478),\r\n"
                   + "(12,'브라움스킨', '학503',20011480,67011480),\r\n"
                   + "(13,'STC', '학513',20011501,67011501),\r\n"
                   + "(14,'요트부', '학502',20011502,68011481),\r\n"
                   + "(15,'최강유도', '학508',21011550,68011509),\r\n"
                   + "(16,'마스터', '학528',21011554,68011515),\r\n"
                   + "(17,'죽순회', '학519',21011571,69011572),\r\n"
                   + "(18,'두바퀴', '학518',21011572,69011579),\r\n"
                   + "(19,'인터페이스', '학529',21011579,69011580),\r\n"
                   + "(20,'별무리', '학520',21011580,69013123),\r\n"
                   + "(21,'세종서회', '학604',21013123,69013132),\r\n"
                   + "(22,'유마프렌', '학511',21013132,69013133),\r\n"
                   + "(23,'레지나', '학504',21013133,69013136),\r\n"
                   + "(24,'세종문학회', '학532',21013136,70011676),\r\n"
                   + "(25,'한손', '학603',21011676,71030008);";
              stmt.executeUpdate(str2[i]);   i++;
              
             str2[i] ="INSERT INTO `madang`.`join_club`\r\n"
                   + "(`number`,`club_clubid`,`student_studentid`)\r\n"
                   + "VALUES\r\n"
                   + "(1,1,20010989),\r\n"
                   + "(2,2,20010378),\r\n"
                   + "(3,3,20010962),\r\n"
                   + "(4,4,20010968),\r\n"
                   + "(5,5,20011084),\r\n"
                   + "(6,6,20012004),\r\n"
                   + "(7,7,20010681),\r\n"
                   + "(8,8,20011005),\r\n"
                   + "(9,9,20011023),\r\n"
                   + "(10,10,20011466),\r\n"
                   + "(11,11,20011478),\r\n"
                   + "(12,12,20011480),\r\n"
                   + "(13,13,20011501),\r\n"
                   + "(14,14,20011502),\r\n"
                   + "(15,15,21011550),\r\n"
                   + "(16,16,21011554),\r\n"
                   + "(17,17,21011571),\r\n"
                   + "(18,18,21011572),\r\n"
                   + "(19,19,21011579),\r\n"
                   + "(20,20,21011580),\r\n"
                   + "(21,21,21013123),\r\n"
                   + "(22,22,21013132),\r\n"
                   + "(23,23,21013133),\r\n"
                   + "(24,24,21013136),\r\n"
                   + "(25,25,21011676),\r\n"
                   + "(26,1,20010378),\r\n"
                   + "(27,2,20010962),\r\n"
                   + "(28,3,20010968),\r\n"
                   + "(29,4,20011084),\r\n"
                   + "(30,5,20012004),\r\n"
                   + "(31,6,20010681),\r\n"
                   + "(32,7,20011005),\r\n"
                   + "(33,8,20011023),\r\n"
                   + "(34,9,20011466),\r\n"
                   + "(35,10,20011478),\r\n"
                   + "(36,11,20011480),\r\n"
                   + "(37,12,20011501),\r\n"
                   + "(38,13,20011502),\r\n"
                   + "(39,14,21011550),\r\n"
                   + "(40,15,21011554),\r\n"
                   + "(41,16,21011571),\r\n"
                   + "(42,17,21011572),\r\n"
                   + "(43,18,21011579),\r\n"
                   + "(44,19,21011580),\r\n"
                   + "(45,20,21013123),\r\n"
                   + "(46,21,21013132),\r\n"
                   + "(47,22,21013133),\r\n"
                   + "(48,23,21013136),\r\n"
                   + "(49,24,21011676),\r\n"
                   + "(50,25,20010989);";
              stmt.executeUpdate(str2[i]);   i++;
              
             str2[i] ="INSERT INTO `madang`.`belong`\r\n"
                   + "(`number`,`Dept_deptid`,`professor_professorid`)\r\n"
                   + "VALUES\r\n"
                   + "(1,1,64010989),\r\n"
                   + "(2,2,65010378),\r\n"
                   + "(3,3,66010962),\r\n"
                   + "(4,4,66010968),\r\n"
                   + "(5,5,66011084),\r\n"
                   + "(6,6,66012004),\r\n"
                   + "(7,7,67010681),\r\n"
                   + "(8,8,67011005),\r\n"
                   + "(9,9,67011023),\r\n"
                   + "(10,10,67011466),\r\n"
                   + "(11,11,67011478),\r\n"
                   + "(12,12,67011480),\r\n"
                   + "(13,13,67011501),\r\n"
                   + "(14,14,68011481),\r\n"
                   + "(15,15,68011509),\r\n"
                   + "(16,16,68011515),\r\n"
                   + "(17,17,69011572),\r\n"
                   + "(18,18,69011579),\r\n"
                   + "(19,19,69011580),\r\n"
                   + "(20,20,69013123),\r\n"
                   + "(21,21,69013132),\r\n"
                   + "(22,22,69013133),\r\n"
                   + "(23,23,69013136),\r\n"
                   + "(24,24,70011676),\r\n"
                   + "(25,25,71030008),\r\n"
                   + "(26,9,67011466),\r\n"
                   + "(27,10,67011023),\r\n"
                   + "(28,14,68011509),\r\n"
                   + "(29,15,68011481);";
              stmt.executeUpdate(str2[i]);   i++;
              
             
             str2[i] ="INSERT INTO `madang`.`course_history`\r\n"
                   + "(`number`,`attendance_score`,`midterm_score`,`final_score`,`etc_score`,\r\n"
                   + "`total_score`,`average_score`,`student_studentid`,\r\n"
                   + "`professor_professorid`,`course_courseid`,\r\n"
                   + "`year`,`semester`,`get_grade`,`new_insert`)\r\n"
                   + "VALUES\r\n"
                   + "(1,10,0,0,10,20,'F',20010989,67011480,36,2021,1,3,   null),\r\n"
                   + "(2,20,30,40,10,100,'A+',20010378,67011501,39,2021,1,3,   null),\r\n"
                   + "(3,20,25,10,10,65,'C+',20010962,68011481,42,2021,1,3,   null),\r\n"
                   + "(4,15,0,10,10,35,'F',20010968,68011509,45,2021,1,3,   null),\r\n"
                   + "(5,20,30,0,10,60,'C0',20011084,68011515,48,2021,1,3,   null),\r\n"
                   + "(6,20,15,20,10,65,'C+',20012004,69011572,51,2021,1,3,   null),\r\n"
                   + "(7,20,30,40,10,100,'A+',20010681,69011579,54,2021,1,3,   null),\r\n"
                   + "(8,20,30,40,10,100,'A+',20011005,69011580,57,2021,1,3,   null),\r\n"
                   + "(9,18,30,40,10,98,'A+',20011023,69013123,60,2021,1,3,   null),\r\n"
                   + "(10,18,30,40,10,98,'A+',20011466,69013132,63,2021,1,3,   null),\r\n"
                   + "(11,18,30,40,10,98,'A+',20011478,69013133,66,2021,1,3,   null),\r\n"
                   + "(12,20,15,40,10,85,'A+',20011480,69013136,69,2021,1,3,   null),\r\n"
                   + "(13,20,18,20,10,68,'C+',20011501,70011676,72,2021,1,3,   null),\r\n"
                   + "(14,20,30,40,10,100,'A+',20011502,71030008,75,2021,1,3,   null),\r\n"
                   + "(15,20,30,40,2,92,'A+',21011550,68011509,43,2021,1,3,   null),\r\n"
                   + "(16,18,15,40,5,78,'B+',21011554,68011515,46,2021,1,3,   null),\r\n"
                   + "(17,18,30,40,3,91,'A+',21011571,69011572,49,2021,1,3,   null),\r\n"
                   + "(18,20,14,30,4,68,'C+',21011572,69011579,52,2021,1,3,   null),\r\n"
                   + "(19,20,25,40,5,90,'A+',21011579,69011580,55,2021,1,3,   null),\r\n"
                   + "(20,20,30,20,2,72,'B0',21011580,69013123,58,2021,1,3,   null),\r\n"
                   + "(21,20,30,20,1,71,'B0',21013123,69013132,61,2021,1,3,   null),\r\n"
                   + "(22,20,15,10,10,55,'D+',21013132,69013133,64,2021,1,3,   null),\r\n"
                   + "(23,20,20,40,6,86,'A+',21013133,69013136,67,2021,1,3,   null),\r\n"
                   + "(24,10,25,40,4,79,'B+',21013136,70011676,70,2021,1,3,   null),\r\n"
                   + "(25,15,20,10,10,55,'D+',21011676,71030008,73,2021,1,3,   null),\r\n"
                   + "(26,18,15,40,5,78,'B+',20010989,64010989,3,2020,2,3,   null),\r\n"
                   + "(27,18,30,40,3,91,'A+',20010378,65010378,6,2020,2,3,   null),\r\n"
                   + "(28,20,30,40,10,100,'A+',20010962,66010962,9,2020,2,3,   null),\r\n"
                   + "(29,18,30,40,10,98,'A+',20010968,66010968,12,2020,2,3,   null),\r\n"
                   + "(30,18,30,40,10,98,'A+',20011084,66011084,15,2020,2,3,   null),\r\n"
                   + "(31,18,30,40,10,98,'A+',20012004,66012004,18,2020,2,3,   null),\r\n"
                   + "(32,20,15,40,10,85,'A+',20010681,67010681,21,2020,2,3,   null),\r\n"
                   + "(33,20,18,20,10,68,'C+',20011005,67011005,24,2020,2,3,   null),\r\n"
                   + "(34,20,30,40,10,100,'A+',20011023,67011023,27,2020,2,3,   null),\r\n"
                   + "(35,20,30,40,2,92,'A+',20011466,67011466,30,2020,2,3,   null),\r\n"
                   + "(36,18,15,40,5,78,'B+',20011478,67011478,33,2020,2,3,   null),\r\n"
                   + "(37,18,30,40,3,91,'A+',20011480,67011480,36,2020,2,3,   null),\r\n"
                   + "(38,20,14,30,4,68,'C+',20011501,67011501,39,2020,2,3,   null),\r\n"
                   + "(39,20,25,40,5,90,'A+',20011502,68011481,42,2020,2,3,   null),\r\n"
                   + "(40,18,30,40,10,98,'A+',20010989,64010989,1,2020,1,3,   null),\r\n"
                   + "(41,18,30,40,10,98,'A+',20010378,65010378,4,2020,1,3,   null),\r\n"
                   + "(42,20,15,40,10,85,'A+',20010962,66010962,8,2020,1,3,   null),\r\n"
                   + "(43,20,18,20,10,68,'C+',20010968,66010968,10,2020,1,3,   null),\r\n"
                   + "(44,20,30,40,10,100,'A+',20011084,66011084,14,2020,1,3,   null),\r\n"
                   + "(45,20,30,40,2,92,'A+',20012004,66012004,16,2020,1,3,   null),\r\n"
                   + "(46,18,15,40,5,78,'B+',20010681,67010681,19,2020,1,3,   null),\r\n"
                   + "(47,18,30,40,3,91,'A+',20011005,67011005,22,2020,1,3,   null),\r\n"
                   + "(48,20,14,30,4,68,'C+',20011023,67011023,25,2020,1,3,   null),\r\n"
                   + "(49,20,25,40,5,90,'A+',20011466,67011466,28,2020,1,3,   null),\r\n"
                   + "(50,20,30,20,2,72,'B0',20011478,67011478,31,2020,1,3,   null),\r\n"
                   + "(51,20,30,20,1,71,'B0',20011480,67011480,34,2020,1,3,   null),\r\n"
                   + "(52,20,15,10,10,55,'D+',20011501,67011501,37,2020,1,3,   null),\r\n"
                   + "(53,20,20,40,6,86,'A+',20011502,68011481,40,2020,1,3,   null);";
              stmt.executeUpdate(str2[i]);   i++;
              
             str2[i] ="INSERT INTO `madang`.`course`(`courseid`,`divided_class`,`name`,`day`,`start_class`,`get_grade`,`time`,`dept`,`office`)\r\n"
                   + "VALUES\r\n"
                   + "(1,1,'한국문학의이해','월',3,3,2,'국어국문학과','집현관 508호')   ,\r\n"
                   + "(2,1,'국어문법론','화',4,3,2,'국어국문학과','집현관 509호')   ,\r\n"
                   + "(3,2,'국어문법론','월',1,3,2,'국어국문학과','집현관 510호')   ,\r\n"
                   + "(4,1,'영어속의 논리','화',3,3,2,'영어영문학','집현관 315호')   ,\r\n"
                   + "(5,2,'영어속의 논리','수',1,3,2,'영어영문학','집현관 316호')   ,\r\n"
                   + "(6,1,'영문법의 이해','월',2,3,2,'영어영문학','집현관 317호')   ,\r\n"
                   + "(7,1,'일본어문법','목',4,3,2,'일어일문학','집현관 415호')   ,\r\n"
                   + "(8,2,'일본어문법','금',3,3,2,'일어일문학','집현관 416호')   ,\r\n"
                   + "(9,1,'일본어작문','화',5,3,2,'일어일문학','집현관 417호')   ,\r\n"
                   + "(10,1,'중국중국어1','수',6,3,2,'중국통상학','집현관 213호')   ,\r\n"
                   + "(11,1,'중국경제론','화',4,3,2,'중국통상학','집현관 214호')   ,\r\n"
                   + "(12,2,'중국경제론','수',3,3,2,'중국통상학','집현관 215호')   ,\r\n"
                   + "(13,1,'한국고대사','목',2,3,2,'역사학과','집현관 201호')   ,\r\n"
                   + "(14,2,'한국고대사','화',1,3,2,'역사학과','집현관 202호')   ,\r\n"
                   + "(15,1,'서양고대사','금',5,3,2,'역사학과','집현관 203호')   ,\r\n"
                   + "(16,1,'학습심리학','금',4,3,2,'교육학과','집현관 606호')   ,\r\n"
                   + "(17,1,'교육학의탐구','수',6,3,2,'교육학과','집현관 607호')   ,\r\n"
                   + "(18,2,'교육학의탐구','목',4,3,2,'교육학과','집현관 608호')   ,\r\n"
                   + "(19,1,'인사행정론','수',2,3,2,'행정학과','집현관 801호')   ,\r\n"
                   + "(20,2,'인사행정론','목',1,3,2,'행정학과','집현관 802호')   ,\r\n"
                   + "(21,1,'조직론1','금',3,3,2,'행정학과','집현관 803호')   ,\r\n"
                   + "(22,1,'경제원론1','수',6,3,2,'경제학과','광개707호')   ,\r\n"
                   + "(23,1,'경제통계','목',2,3,2,'경제학과','광개708호')   ,\r\n"
                   + "(24,2,'경제통계','월',3,3,2,'경제학과','광개709호')   ,\r\n"
                   + "(25,1,'경영학원론','목',5,3,2,'외식경영학과','광개토관 518호')   ,\r\n"
                   + "(26,1,'호텔관광산업의이해','금',2,3,2,'외식경영학과','광개토관 519호')   ,\r\n"
                   + "(27,2,'호텔관광산업의이해','목',1,3,2,'외식경영학과','광개토관 520호')   ,\r\n"
                   + "(28,1,'관광경영론','금',4,3,2,'글로벌조리학과','광개토관 818호')   ,\r\n"
                   + "(29,2,'관광경영론','목',3,3,2,'글로벌조리학과','광개토관 819호')   ,\r\n"
                   + "(30,1,'호텔경영론','화',5,3,2,'글로벌조리학과','광개토관 820호')   ,\r\n"
                   + "(31,1,'역학1','수',2,3,2,'물리천문학과','영실관 114호')   ,\r\n"
                   + "(32,2,'역학1','월',3,3,2,'물리천문학과','영실관 115호')   ,\r\n"
                   + "(33,1,'수리물리1','금',6,3,2,'물리천문학과','영실관 116호')   ,\r\n"
                   + "(34,1,'유기화학1','목',5,3,2,'화학과','영실관 216호')   ,\r\n"
                   + "(35,1,'무기화학','금',4,3,2,'화학과','영실관 217호')   ,\r\n"
                   + "(36,2,'무기화학','목',3,3,2,'화학과','영실관 218호')   ,\r\n"
                   + "(37,1,'전기회로','화',4,3,2,'전자정보통신공학과','충무관 923호')   ,\r\n"
                   + "(38,2,'전기회로','금',2,3,2,'전자정보통신공학과','충무관 924호')   ,\r\n"
                   + "(39,1,'디지털논리회로','월',3,3,2,'전자정보통신공학과','충무관 925호')   ,\r\n"
                   + "(40,1,'C프로그래밍및실습','화',5,3,2,'컴퓨터공학과','대양AI센터 443호')   ,\r\n"
                   + "(41,2,'C프로그래밍및실습','목',2,3,2,'컴퓨터공학과','대양AI센터 444호')   ,\r\n"
                   + "(42,1,'자료구조및실습','수',3,3,2,'컴퓨터공학과','대양AI센터 445호')   ,\r\n"
                   + "(43,1,'운영체제','목',4,3,2,'소프트웨어학과','대양AI 403호')   ,\r\n"
                   + "(44,2,'운영체제','금',2,3,2,'소프트웨어학과','대양AI 404호')   ,\r\n"
                   + "(45,1,'데이터베이스','월',1,3,2,'소프트웨어학과','대양AI 405호')   ,\r\n"
                   + "(46,1,'정보사회와윤리','목',3,3,2,'정보보호학과','대양AI센터 406호')   ,\r\n"
                   + "(47,1,'사이버전개론','화',2,3,2,'정보보호학과','대양AI센터 407호')   ,\r\n"
                   + "(48,2,'사이버전개론','수',5,3,2,'정보보호학과','대양AI센터 408호')   ,\r\n"
                   + "(49,1,'열역학','수',3,3,2,'기계공학과','충무관 1010호')   ,\r\n"
                   + "(50,1,'고체역학','월',5,3,2,'기계공학과','충무관 1011호')   ,\r\n"
                   + "(51,2,'고체역학','수',6,3,2,'기계공학과','충무관 1012호')   ,\r\n"
                   + "(52,1,'현대물리','월',4,3,2,'나노신소재공학과','충무관 817호')   ,\r\n"
                   + "(53,2,'현대물리','화',3,3,2,'나노신소재공학과','충무관 818호')   ,\r\n"
                   + "(54,1,'고체물리','목',5,3,2,'나노신소재공학과','충무관 819호')   ,\r\n"
                   + "(55,1,'군대윤리','수',4,3,2,'국방시스템공학과','광개토관 1010C호')   ,\r\n"
                   + "(56,1,'군사학개론','목',2,3,2,'국방시스템공학과','광개토관 1011C호')   ,\r\n"
                   + "(57,2,'군사학개론','월',3,3,2,'국방시스템공학과','광개토관 1012C호')   ,\r\n"
                   + "(58,1,'기초소묘','화',6,3,2,'회화과','진관홀 311호')   ,\r\n"
                   + "(59,2,'기초소묘','월',2,3,2,'회화과','진관홀 312호')   ,\r\n"
                   + "(60,1,'인물화','목',3,3,2,'회화과','진관홀 313호')   ,\r\n"
                   + "(61,1,'연주1','수',5,3,2,'음악과','모짜르트홀 103호')   ,\r\n"
                   + "(62,2,'연주1','월',2,3,2,'음악과','모짜르트홀 104호')   ,\r\n"
                   + "(63,1,'딕션1','목',3,3,2,'음악과','모짜르트홀 105호')   ,\r\n"
                   + "(64,1,'골프','금',4,3,2,'체육학과','용덕관 115호')   ,\r\n"
                   + "(65,1,'스포츠특강1','화',3,3,2,'체육학과','용덕관 116호')   ,\r\n"
                   + "(66,2,'스포츠특강1','수',2,3,2,'체육학과','용덕관 117호')   ,\r\n"
                   + "(67,1,'워크샵1','화',4,3,2,'무용과','용덕관 404호')   ,\r\n"
                   + "(68,1,'발레태크닉1','수',3,3,2,'무용과','용덕관 405호')   ,\r\n"
                   + "(69,2,'발레태크닉1','목',5,3,2,'무용과','용덕관 406호')   ,\r\n"
                   + "(70,1,'연극의이해','화',4,3,2,'영화예술학과','광개토관 1202호')   ,\r\n"
                   + "(71,2,'연극의이해','금',3,3,2,'영화예술학과','광개토관 1203호')   ,\r\n"
                   + "(72,1,'기초연기1','목',1,3,2,'영화예술학과','광개토관 1204호')   ,\r\n"
                   + "(73,1,'인공지능의이해','수',2,3,2,'인공지능학과','대양AI센터 410호')   ,\r\n"
                   + "(74,2,'인공지능의이해','목',5,3,2,'인공지능학과','대양AI센터 411호')   ,\r\n"
                   + "(75,1,'머신러닝','수',4,3,2,'인공지능학과','대양AI센터 412호');";
              stmt.executeUpdate(str2[i]);   i++;
              
             str2[i] ="INSERT INTO `madang`.`dept`(`deptid`,`name`,`phone_number`,`office`,`professor_professorid`)\r\n"
                   + "VALUES\r\n"
                   + "(1,'국어국문학과','02-3408-4301','집현관 908호',64010989)   ,\r\n"
                   + "(2,'영어영문학','02-3408-3302','집현관 715호',65010378)   ,\r\n"
                   + "(3,'일어일문학','02-3408-3303','집현관 715호',66010962)   ,\r\n"
                   + "(4,'중국통상학','02-3408-3309','집현관 412호',66010968)   ,\r\n"
                   + "(5,'역사학과','02-3408-3305','집현관 915호',66011084)   ,\r\n"
                   + "(6,'교육학과','02-3408-3304','집현관 706호',66012004)   ,\r\n"
                   + "(7,'행정학과','02-3408-3308','집현관 604호',67010681)   ,\r\n"
                   + "(8,'경제학과','02-3408-3306','광개704B호',67011005)   ,\r\n"
                   + "(9,'외식경영학과','02-3408-3313','광개토관 517호',67011023)   ,\r\n"
                   + "(10,'글로벌조리학과','02-3408-1831','광개토관 817호',67011466)   ,\r\n"
                   + "(11,'물리천문학과','02-3408-3316','영실관 113호',67011478)   ,\r\n"
                   + "(12,'화학과','02-3408-3317','영실관 215호',67011480)   ,\r\n"
                   + "(13,'전자정보통신공학과','02-3408-4467','충무관 922호',67011501)   ,\r\n"
                   + "(14,'컴퓨터공학과','02-3408-3321','대양AI센터 442호',68011481)   ,\r\n"
                   + "(15,'소프트웨어학과','02-3408-3667','대양AI 402호',68011509)   ,\r\n"
                   + "(16,'정보보호학과','02-3408-4181','대양AI센터 404호',68011515)   ,\r\n"
                   + "(17,'기계공학과','02-3408-3663','충무관 1009호',69011572)   ,\r\n"
                   + "(18,'나노신소재공학과','02-3408-3664','충무관 816호',69011579)   ,\r\n"
                   + "(19,'국방시스템공학과','02-3408-3674','광개토관 1009C호',69011580)   ,\r\n"
                   + "(20,'회화과','02-3408-3322','진관홀 310호',69013123)   ,\r\n"
                   + "(21,'음악과','02-3408-3324','모짜르트홀 102호',69013132)   ,\r\n"
                   + "(22,'체육학과','02-3408-3325','용덕관 114호',69013133)   ,\r\n"
                   + "(23,'무용과','02-3408-3326','용덕관 403호',69013136)   ,\r\n"
                   + "(24,'영화예술학과','02-3408-3327','광개토관 1201호',70011676)   ,\r\n"
                   + "(25,'인공지능학과','02-6935-2483','대양AI센터 409호',71030008);";
              stmt.executeUpdate(str2[i]);   i++;
              
             str2[i] ="INSERT INTO `madang`.`dept_course`(`number`,`Dept_deptid`,`course_courseid`)\r\n"
                   + "VALUES\r\n"
                   + "(1,1,1)   ,\r\n"
                   + "(2,1,2)   ,\r\n"
                   + "(3,1,3)   ,\r\n"
                   + "(4,2,4)   ,\r\n"
                   + "(5,2,5)   ,\r\n"
                   + "(6,2,6)   ,\r\n"
                   + "(7,3,7)   ,\r\n"
                   + "(8,3,8)   ,\r\n"
                   + "(9,3,9)   ,\r\n"
                   + "(10,4,10)   ,\r\n"
                   + "(11,4,11)   ,\r\n"
                   + "(12,4,12)   ,\r\n"
                   + "(13,5,13)   ,\r\n"
                   + "(14,5,14)   ,\r\n"
                   + "(15,5,15)   ,\r\n"
                   + "(16,6,16)   ,\r\n"
                   + "(17,6,17)   ,\r\n"
                   + "(18,6,18)   ,\r\n"
                   + "(19,7,19)   ,\r\n"
                   + "(20,7,20)   ,\r\n"
                   + "(21,7,21)   ,\r\n"
                   + "(22,8,22)   ,\r\n"
                   + "(23,8,23)   ,\r\n"
                   + "(24,8,24)   ,\r\n"
                   + "(25,9,25)   ,\r\n"
                   + "(26,9,26)   ,\r\n"
                   + "(27,9,27)   ,\r\n"
                   + "(28,10,28)   ,\r\n"
                   + "(29,10,29)   ,\r\n"
                   + "(30,10,30)   ,\r\n"
                   + "(31,11,31)   ,\r\n"
                   + "(32,11,32)   ,\r\n"
                   + "(33,11,33)   ,\r\n"
                   + "(34,12,34)   ,\r\n"
                   + "(35,12,35)   ,\r\n"
                   + "(36,12,36)   ,\r\n"
                   + "(37,13,37)   ,\r\n"
                   + "(38,13,38)   ,\r\n"
                   + "(39,13,39)   ,\r\n"
                   + "(40,14,40)   ,\r\n"
                   + "(41,14,41)   ,\r\n"
                   + "(42,14,42)   ,\r\n"
                   + "(43,15,43)   ,\r\n"
                   + "(44,15,44)   ,\r\n"
                   + "(45,15,45)   ,\r\n"
                   + "(46,16,46)   ,\r\n"
                   + "(47,16,47)   ,\r\n"
                   + "(48,16,48)   ,\r\n"
                   + "(49,17,49)   ,\r\n"
                   + "(50,17,50)   ,\r\n"
                   + "(51,17,51)   ,\r\n"
                   + "(52,18,52)   ,\r\n"
                   + "(53,18,53)   ,\r\n"
                   + "(54,18,54)   ,\r\n"
                   + "(55,19,55)   ,\r\n"
                   + "(56,19,56)   ,\r\n"
                   + "(57,19,57)   ,\r\n"
                   + "(58,20,58)   ,\r\n"
                   + "(59,20,59)   ,\r\n"
                   + "(60,20,60)   ,\r\n"
                   + "(61,21,61)   ,\r\n"
                   + "(62,21,62)   ,\r\n"
                   + "(63,21,63)   ,\r\n"
                   + "(64,22,64)   ,\r\n"
                   + "(65,22,65)   ,\r\n"
                   + "(66,22,66)   ,\r\n"
                   + "(67,23,67)   ,\r\n"
                   + "(68,23,68)   ,\r\n"
                   + "(69,23,69)   ,\r\n"
                   + "(70,24,70)   ,\r\n"
                   + "(71,24,71)   ,\r\n"
                   + "(72,24,72)   ,\r\n"
                   + "(73,25,73)   ,\r\n"
                   + "(74,25,74)   ,\r\n"
                   + "(75,25,75)   ;";
              stmt.executeUpdate(str2[i]);   i++;
              
              
              
              str2[i] ="INSERT INTO `madang`.`professor`(`professorid`,`name`,`address`,`phone_number`,`e-mail`)\r\n"
                    + "VALUES\r\n"
                    + "(64010989,'김한응','경기도 수원시 권선구 율전로 2(입북동)','010-7334-6852','justo.faucibus.lectus@montesnasceturridiculusprofessor')   ,\r\n"
                    + "(65010378,'한성현','경기도 수원시 권선구 율전로 9(입북동)','010-4853-6756','Cras@Vivamus.org')   ,\r\n"
                    + "(66010962,'김영득','울산광역시 울주군 삼남읍 향교로 70','010-2603-3407','neque.Nullam@consequatauctor.edu')   ,\r\n"
                    + "(66010968,'정은희','울산광역시 울주군 삼남읍 향교로 76(우일빌라)','010-8610-5818','elit.fermentum@Nuncquisarcu.co.uk')   ,\r\n"
                    + "(66011084,'김양현','인천광역시 계양구 향교로 32(계산동, 성도빌라)','010-0148-0655','dictum@massarutrummagna.edu')   ,\r\n"
                    + "(66012004,'이미라','경기도 가평군 가평읍 향교로 4-6','010-0875-0307','sapien.cursus.in@facilisismagna.ca')   ,\r\n"
                    + "(67010681,'심지영','경기도 수원시 팔달구 향교로 3(매산로1가)','010-1004-3442','sem.consequat.nec@Vivamus.edu')   ,\r\n"
                    + "(67011005,'고수정','경기도 성남시 분당구 황새울로 4(정자동)','010-2550-6555','tellus.Phasellus@maurisaliquam.edu')   ,\r\n"
                    + "(67011023,'유응구','경기도 성남시 분당구 황새울로 216(수내동)','010-7524-2665','libero.nec.ligula@risusInmi.co.uk')   ,\r\n"
                    + "(67011466,'이병열','경기도 용인시 처인구 백암면 황새울로 231','010-0424-6364','sodales.purus.in@dolor.co.uk')   ,\r\n"
                    + "(67011478,'강흥석','경기도 성남시 분당구 황새울로12번길 11-3(정자동)','010-5375-7555','Mauris.vel.turpis@VivamusnisiMauris.co.uk')   ,\r\n"
                    + "(67011480,'백준걸','전라북도 전주시 완산구 충경로 25(중앙동1가)','010-6254-0574','tellus.Aenean@fermentum.org')   ,\r\n"
                    + "(67011501,'이지영','경기도 고양시 덕양구 충경로 31-1(행신동)','010-3274-0544','in.cursus.et@vulputatemauris.edu')   ,\r\n"
                    + "(68011481,'김미현','경기도 고양시 덕양구 충경로 138(행신동, 소만마을3단지아파트)','010-3438-1848','Phasellus@mollisDuis.edu')   ,\r\n"
                    + "(68011509,'한미우','경기도 양평군 강상면 백양길90번길 21','010-7132-6061','consectetuer.adipiscing@Proin.com')   ,\r\n"
                    + "(68011515,'최재석','경기도 양평군 강상면 백양길 49-3','010-0660-1243','non.feugiat@ideratEtiam.co.uk')   ,\r\n"
                    + "(69011572,'안성윤','광주광역시 남구 산남로 678(양과동)','010-6604-5230','Suspendisse.tristique.neque@facilisisnon.com')   ,\r\n"
                    + "(69011579,'하인화','경기도 고양시 일산서구 산남로 62-7(구산동)','010-8312-1536','gravida.nunc.sed@tellus.co.uk')   ,\r\n"
                    + "(69011580,'박상철','서울특별시 강남구 봉은사로 지하102(역삼동)','010-6558-2563','convallis.erat@gravida.co.uk')   ,\r\n"
                    + "(69013123,'한겨레','서울특별시 강남구 봉은사로 114(역삼동)','010-4533-7431','sed.sem.egestas@Donecconsectetuer.net')   ,\r\n"
                    + "(69013132,'김미연','인천광역시 서구 강남로 6(석남동)','010-0024-8035','egestas.hendrerit@porttitor.com')   ,\r\n"
                    + "(69013133,'한미우','울산광역시 남구 강남로 348(삼산동, 아데라움아파트)','010-6223-7483','rhoncus.Nullam.velit@acurnaUt.edu')   ,\r\n"
                    + "(69013136,'최재석','충청북도 괴산군 문광면 대명1길 10-5','010-2824-5510','fringilla.est.Mauris@facilisis.ca')   ,\r\n"
                    + "(70011676,'안성윤','경기도 용인시 기흥구 강남로 23(구갈동)','010-8608-7024','aliquam.eros@sollicitudina.co.uk')   ,\r\n"
                    + "(71030008,'하인화','서울특별시 종로구 대명1길 15-2(명륜4가)','010-8021-3876','enim@massa.com')   ;";
               stmt.executeUpdate(str2[i]);   i++;
              
              str2[i] ="INSERT INTO `madang`.`tuition_history`(`studentid`,`payment_year`,`payment_semester`,`total_tuition`,`total_payment`,`last_paymentday`,`tuition_account`)\r\n"
                    + "VALUES\r\n"
                    + "(20010989,2021,1,4700000,4700000,STR_TO_DATE('2021-02-05','%Y-%m-%d'),'706728-9483')   ,\r\n"
                    + "(20010378,2021,1,4700000,4700000,STR_TO_DATE('2021-02-06','%Y-%m-%d'),'405938-7532')   ,\r\n"
                    + "(20010962,2021,1,4700000,4700000,STR_TO_DATE('2021-02-07','%Y-%m-%d'),'692512-0120')   ,\r\n"
                    + "(20010968,2021,1,4700000,0,STR_TO_DATE('2021-02-08','%Y-%m-%d'),'605837-0419')   ,\r\n"
                    + "(20011084,2021,1,4700000,4700000,STR_TO_DATE('2021-02-09','%Y-%m-%d'),'205314-7290')   ,\r\n"
                    + "(20012004,2021,1,4700000,4700000,STR_TO_DATE('2021-02-10','%Y-%m-%d'),'823682-0455')   ,\r\n"
                    + "(20010681,2021,1,4700000,4700000,STR_TO_DATE('2021-02-11','%Y-%m-%d'),'415767-1241')   ,\r\n"
                    + "(20011005,2021,1,4700000,4700000,STR_TO_DATE('2021-02-12','%Y-%m-%d'),'646996-0279')   ,\r\n"
                    + "(20011023,2021,1,4700000,4700000,STR_TO_DATE('2021-02-13','%Y-%m-%d'),'908524-8400')   ,\r\n"
                    + "(20011466,2021,1,4700000,100000,STR_TO_DATE('2021-02-14','%Y-%m-%d'),'196137-9425')   ,\r\n"
                    + "(20011478,2021,1,4700000,4700000,STR_TO_DATE('2021-02-15','%Y-%m-%d'),'327569-4671')   ,\r\n"
                    + "(20011480,2021,1,4700000,4700000,STR_TO_DATE('2021-02-16','%Y-%m-%d'),'242515-7845')   ,\r\n"
                    + "(20011501,2021,1,4900000,4900000,STR_TO_DATE('2021-02-17','%Y-%m-%d'),'972877-8458')   ,\r\n"
                    + "(20011502,2021,1,4900000,4900000,STR_TO_DATE('2021-02-18','%Y-%m-%d'),'777251-5321')   ,\r\n"
                    + "(21011550,2021,1,4900000,200000,STR_TO_DATE('2021-02-19','%Y-%m-%d'),'112952-8772')   ,\r\n"
                    + "(21011554,2021,1,4900000,4900000,STR_TO_DATE('2021-02-20','%Y-%m-%d'),'455331-6250')   ,\r\n"
                    + "(21011571,2021,1,4900000,4900000,STR_TO_DATE('2021-02-21','%Y-%m-%d'),'466465-3468')   ,\r\n"
                    + "(21011572,2021,1,4900000,4900000,STR_TO_DATE('2021-02-22','%Y-%m-%d'),'389152-7586')   ,\r\n"
                    + "(21011579,2021,1,4900000,4900000,STR_TO_DATE('2021-02-23','%Y-%m-%d'),'413876-2291')   ,\r\n"
                    + "(21011580,2021,1,4900000,800000,STR_TO_DATE('2021-02-24','%Y-%m-%d'),'197818-3398')   ,\r\n"
                    + "(21013123,2021,1,4900000,4900000,STR_TO_DATE('2021-02-25','%Y-%m-%d'),'424669-2232')   ,\r\n"
                    + "(21013132,2021,1,4900000,4900000,STR_TO_DATE('2021-02-26','%Y-%m-%d'),'704758-1165')   ,\r\n"
                    + "(21013133,2021,1,4900000,1000000,STR_TO_DATE('2021-02-27','%Y-%m-%d'),'078084-2704')   ,\r\n"
                    + "(21013136,2021,1,4900000,4900000,STR_TO_DATE('2021-02-28','%Y-%m-%d'),'927483-6858')   ,\r\n"
                    + "(21011676,2021,1,4900000,4900000,STR_TO_DATE('2021-03-01','%Y-%m-%d'),'457193-6105')   ;  ";
               stmt.executeUpdate(str2[i]);   i++;
               
               String str3 = "update course_history,tuition_history set new_insert = '등록금 미납' "
                     + "where(tuition_history.studentid = course_history.student_studentid and total_tuition>total_payment);";
              str3 = "SET FOREIGN_KEY_CHECKS=0;";
              stmt.executeUpdate(str3);
              
              txtResult.setText("초기화 되었습니다.");

         }
       //검색
         if (e.getSource() == BtnIDU) {//--------------------------------------------------------------------------------------------------------------------
        	 
        	 try {
	             String query = initF.getText();
	             stmt.executeUpdate(query);
	             txtResult.setText("퀴리문 실행");
        	 }
        	 catch(Exception e3) {
        		 txtResult.setText("퀴리문 실행오류");
        	 }
        	 
             }
       //검색
         if (e.getSource() == Cancel) {//--------------------------------------------------------------------------------------------------------------------
        	 initF.setText("");
         }
           

       //검색
         if (e.getSource() == ShowTable) {

             String query = "select * from belong;";
              txtResult.setText("");
              txtResult.setText("교수소속학과테이블\n");
              txtResult.append("일련번호\t학과번호\t일련번호\n");
              rs = stmt.executeQuery(query);
              while (rs.next()) {
                 String str =rs.getInt(1) + "\t" + rs.getInt(2)+ "\t" 
                       +rs.getInt(3) + "\t"
                       + "\n";
                 txtResult.append(str);              
               
              }
              
              query = "select * from club;";
              txtResult.append("\n");
              txtResult.append("동아리테이블\n");
              txtResult.append("동아리번호\t동아리이름\t동아리방\t학생회장번호\t동아리지도교수번호\n");
              rs = stmt.executeQuery(query);
              while (rs.next()) {
                 String  str =rs.getInt(1) + "\t" + rs.getString(2) + "\t" + rs.getString(3) + "\t"+
                      rs.getInt(4) + "\t" + rs.getInt(5) + "\t" + 
                       "\n";
                 txtResult.append(str);
              }
              
              query = "select * from course;";
              txtResult.append("\n");
              txtResult.append("강좌테이블\n");
              txtResult.append("강좌번호\t분반번호\t강좌이름\t강의요일\t강의교시\t취득학점\t강좌시간\t개설학과\t강의실정보\n");
              rs = stmt.executeQuery(query);
              while (rs.next()) {
                 String  str =rs.getInt(1) + "\t" + rs.getInt(2) + "\t" + rs.getString(3) + "\t"+
                      rs.getString(4) + "\t" + rs.getInt(5) + "\t" + rs.getInt(6) + "\t" + rs.getInt(7) + "\t" + 
                      rs.getString(8) + "\t" + rs.getString(9) +  
                       "\n";
                 txtResult.append(str);
              }
              
              query = "select * from course_history;";
              txtResult.append("\n");
              txtResult.append("수강내역테이블\n");
              txtResult.append("일련번호\t출석점수\t중간고사\t기말고사\t기타점수\t총점\t평점\t학생번호\t교수번호\t강좌번호\t개설연도\t개설학기\t취득학점\t신규삽입\n");
              rs = stmt.executeQuery(query);
              while (rs.next()) {
                 String  str =rs.getInt(1) + "\t" + rs.getInt(2) + "\t" + rs.getInt(3) + "\t"+
                      rs.getInt(4) + "\t" + rs.getInt(5) + "\t" + rs.getInt(6) + "\t" + rs.getString(7) + "\t" + 
                      rs.getInt(8) + "\t" + rs.getInt(9) + "\t" + rs.getInt(10) + "\t"+
                      rs.getInt(11) + "\t" + rs.getInt(12) + "\t" + rs.getInt(13)+ "\t"+ rs.getString(14)+
                       "\n";
                 txtResult.append(str);
              }
              query = "select * from dept;";
              txtResult.append("\n");
              txtResult.append("학과테이블\n");
              txtResult.append("학과번호\t학과이름\t학과전화번호\t학과사무실\t학과장번호\n");
              rs = stmt.executeQuery(query);
              while (rs.next()) {
                 String  str =rs.getInt(1) + "\t" + rs.getString(2) + "\t" + rs.getString(3) + "\t"+
                      rs.getString(4) + "\t" + rs.getInt(5)+
                       "\n";
                 txtResult.append(str);
              }
              
              query = "select * from dept_course;";
              txtResult.append("\n");
              txtResult.append("학과개설강좌테이블\n");
              txtResult.append("일련번호\t학과번호\t강좌번호\n");
              rs = stmt.executeQuery(query);
              while (rs.next()) {
                 String  str =rs.getInt(1) + "\t" + rs.getInt(2) + "\t" + rs.getInt(3) + "\t"+
                              "\n";
                 txtResult.append(str);
              }
              
              query = "select * from join_club;";
              txtResult.append("\n");
              txtResult.append("동아리가입목록테이블\n");
              txtResult.append("일련번호\t동아리번호\t학생번호\n");
              rs = stmt.executeQuery(query);
              while (rs.next()) {
                 String  str =rs.getInt(1) + "\t" + rs.getInt(2) + "\t" + rs.getInt(3) + "\t"+
                              "\n";
                 txtResult.append(str);
              }
              
              query = "select * from professor;";
              txtResult.append("\n");
              txtResult.append("교수테이블\n");
              txtResult.append("교수번호\t교수이름\t주소\t\t\t전화번호\te-mail\t\t\n");
              rs = stmt.executeQuery(query);
              while (rs.next()) {
                  String  str =rs.getInt(1) + "\t" + rs.getString(2) + "\t" + rs.getString(3) + "\t"+
                           rs.getString(4) + "\t" + rs.getString(5)+
                            "\n";
                 txtResult.append(str);
              }
              
              query = "select * from student;";
              txtResult.append("\n");
              txtResult.append("학생테이블\n");
              txtResult.append("학생번호\t학생이름\t주소\t\t\t전화번호\te-mail\t\t\t학년\t학기\t담당교수번호\t부전공번호\t등록금계좌번호\t전공번호\n");
          
              rs = stmt.executeQuery(query);
              while (rs.next()) {
                 String str = rs.getInt(1) + "\t" + rs.getString(2) + "\t" + rs.getString(3) + "\t"+
                    rs.getString(4) + "\t" + rs.getString(5) + "\t" + rs.getInt(6) + "\t"+
                    rs.getInt(7) + "\t" + rs.getInt(8) + "\t" + rs.getInt(9) + "\t"+
                    rs.getString(10) + "\t" + rs.getInt(11) + "\t"+
                        "\n";
               txtResult.append(str);
            }
              query = "select * from tuition_history;";
              txtResult.append("\n");
              txtResult.append("등록금납부내역테이블\n");
              txtResult.append("학생번호\t납부연도\t납부학기\t등록금총액\t납부총액\t마지막납부일자\t등록금계좌정보\n");
          
              rs = stmt.executeQuery(query);
              while (rs.next()) {
                 String str = rs.getInt(1) + "\t" + rs.getInt(2) + "\t" + rs.getInt(3) + "\t"+
                       rs.getInt(4) + "\t" + rs.getInt(5) + "\t" + rs.getString(6) + "\t"+
                    rs.getString(7) +"\n";
               txtResult.append(str);
            }


         }
         
      } catch (Exception e2) {
         txtResult.setText("");
         txtResult.setText("쿼리 읽기 실패 :" + e2);
/*      } finally {
         try {
            if (rs != null)
               rs.close();
            if (stmt != null)
               stmt.close();
            if (con != null)
               con.close();
         } catch (Exception e3) {
            // TODO: handle exception
         }
  */
      }
}



}




//---------------------------------------------------------------------------------------------------------------------------교수 Frame
class PFrame extends JFrame implements ActionListener{
	Pschedule ps;
	
	   static Connection con;
	   Statement stmt;
	   ResultSet rs;
	   String Driver = "";
	   String url = "jdbc:mysql://localhost:3306/madang?&serverTimezone=Asia/Seoul&useSSL=false";
	   String userid = "madang";
	   String pwd = "madang";

	
	
	Container a = getContentPane();
	   JTextField Tyear;
	   JTextField Tsemester;
	   JTextField TargetS;
	   JTextField TargetG;
	   
	   JTextArea txtResult, txtStatus;
	   
	   JButton BtnShowCourse;
	   JButton BtnStudent;
	   JButton BtnBelong;
	   JButton BtnSchedule;
	   JButton BtnNowCourse;
	   JButton Cancel;
	   JButton Cancel2;
	   
	JPanel N;
	
	JList list;
	
 public PFrame(String S){
     super(S);
     layInit();
     conDB();
     setVisible(true);
     setTitle(S);

     setBounds(200, 200, 1300, 500); //가로위치,세로위치,가로길이,세로길이
     setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 }
 public void layInit() {
 	txtResult = new JTextArea();
 	txtStatus = new JTextArea(5,30);
 	
 	N = new JPanel();
 	a.setLayout(new BorderLayout());
 	Tyear = new JTextField(10);
 	Tsemester = new JTextField(10);
 	TargetS = new JTextField(10);
 	TargetG = new JTextField(10);
 	
 	
 	BtnShowCourse = new JButton("해당학기에 강의했던 과목");
 	BtnStudent = new JButton("지도하는 학생");
	BtnBelong = new JButton("소속된 학과(학과장 포함)");
	BtnSchedule = new JButton("시간표");
	BtnNowCourse = new JButton("현재 강의 과목 성적 입력");
	Cancel = new JButton("입력취소");
	Cancel2 = new JButton("입력취소");
	
 	
	      JScrollPane scrollPane = new JScrollPane(txtResult);
	      JScrollPane scrollPane2 = new JScrollPane(txtStatus);
	      
	      
	      JPanel N1 = new JPanel();
	      JPanel N2 = new JPanel();
	      JPanel N3 = new JPanel();
	      JPanel N4 = new JPanel();
	      
	      
	      list = new JList();
	      /*-----------------------------------------------------------------------------------------------------리스트(클릭이벤트 구현을 위한 거) 요소 추가시 문법 (add 안됨)
	      list = new JList(items);
	      String[] items = {"A", "B", "C", "D","A","A","A","A","A","A","A","A","A","A","A","A","A","A","A","A","A","A","A","A","A","A","A","A","A","A","A","A","A","A","A","A","A","A","Aㅇㄹㄴㅁ",};//-----------------------------------------------------------리스트 요소로 줄 데이터
	      
	      DefaultListModel listModel = new DefaultListModel();
          listModel.addElement("asdfafsdsdfa");//요소 추가
          
          list.setModel(listModel);
		*/
	      
	      

	      	N1.add( new JLabel("교수님 환영합니다! "+getTitle()+"님"));
	      	
	    	N3.add(new JLabel("년도 : "));
	    	N3.add(Tyear);
	    	N3.add(new JLabel("학기 : "));
	    	N3.add(Tsemester);
	    	  N3.add(BtnShowCourse);
	    	  N3.add(Cancel2);
	    	  
	    	  N2.add(BtnStudent);
	    	  N2.add(BtnBelong);
	    	  N2.add(BtnSchedule);
	    	  
	    	  N4.add(new JLabel("학생 : "));
	    	  N4.add(TargetS);
		      N4.add(new JLabel("입력 : "));
		      N4.add(TargetG);
	    	  N4.add(BtnNowCourse);
	    	  N4.add(Cancel);
	      
	      N.setLayout(new GridLayout(4,1));
	      
	      N.add(N1);
	      N.add(N2);
	      N.add(N3);
	      N.add(N4);
	      
	      
 	
 	
	      a.add("North",N);
	      txtResult.setEditable(false);
	      txtStatus.setEditable(false);
	      
	      JScrollPane scroll = new JScrollPane(list);
	      a.add("Center", scroll);
	      a.add("South", scrollPane2);  
	      
	      BtnShowCourse.addActionListener(this);
	      BtnBelong.addActionListener(this);
	      BtnSchedule.addActionListener(this);
	      BtnNowCourse.addActionListener(this);
	      BtnStudent.addActionListener(this);
	      Cancel.addActionListener(this);
	      Cancel2.addActionListener(this);

list.addMouseListener(new MouseAdapter() {
    public void mouseClicked(MouseEvent evt) {
        JList list = (JList)evt.getSource();
        if (evt.getClickCount() == 2) {
       	 try {
             stmt = con.createStatement();
             
             
            // Double-click detected
        	String a = list.getModel().toString();
        	String[] flag = a.split(" ");
        	
        	
        	if(list.getSelectedIndex()!=0 && flag[0].contains("학생번호")) {
        		String tmp = list.getSelectedValue().toString();
        		DefaultListModel listModel = new DefaultListModel();
        		String [] value = tmp.split(" ");
        		String t = "    ";
                int studentid= Integer.valueOf(value[0]); // 입력될 강의 번호
                String query = "select year,semester,name ,average_score from course_history,course "
                      + "where courseid = course_courseid and student_studentid = "+ studentid +"; ";
                listModel.addElement("");
                listModel.addElement("수강연도"+t+"수강학기"+t+t+t+t+"강의이름"+t+t+t+t+t+"강의성적\n");
                 rs = stmt.executeQuery(query);
                 while (rs.next()) {
                    String str =rs.getInt(1) + t +t+t+t+t+ rs.getInt(2)+ t+ t+t+t+t
                          +rs.getString(3) + t +t+t+t+t+ rs.getString(4)
                          + "\n";
                    listModel.addElement(str);
                 }

                 list.setModel(listModel);
        		
        		
        	}
        	if(list.getSelectedIndex()!=0 && flag[0].contains("강좌번호")) {
        		String tmp = list.getSelectedValue().toString();
        		
        		String [] value = tmp.split(" ");
                int x = Integer.valueOf(value[0]); // 입력될 강의 번호
                /*DefaultListModel listModel = new DefaultListModel();
          listModel.addElement("asdfafsdsdfa");//요소 추가
          
          list.setModel(listModel);*/
                
                DefaultListModel listModel = new DefaultListModel();
                
                String t = "     ";
                
                String query = "select * from student where studentid in "
                      + "(select student_studentid from course_history "
                      + "where (course_courseid = "+ x +")); ";             
                listModel.addElement("학생번호"+t+"학생이름"+t+t+t+t+t+t+t+t+"주소"+t+t+t+t+t+t+t+t+t+"전화번호"+t+t+t+t+t+t+"e-mail"+t+t+t +t +t +t +t +t +
                		t+"학년"+t+"학기"+t+"담당교수번호"+t+"부전공번호"+t+"등록금계좌번호"+t+"전공번호\n");
               rs = stmt.executeQuery(query);
               while (rs.next()) {
                  String str = rs.getInt(1) + t + rs.getString(2) + t +t +t +t + rs.getString(3) + t+t +t +
                        rs.getString(4) + t + rs.getString(5) + t + rs.getInt(6) + t+t +t +
                        rs.getInt(7) + t +t +t + rs.getInt(8) + t +t +t + rs.getInt(9) + t+t +t +
                        rs.getString(10) + t +t +t + rs.getInt(11) + t+
                            "\n";
                  listModel.addElement(str);
                }

               list.setModel(listModel);
        		
        	}
       	 }catch (Exception e2) {
             //txtResult.setText("");
             //txtResult.setText("쿼리 읽기 실패 :" + e2);
    /*      } finally {
             try {
                if (rs != null)
                   rs.close();
                if (stmt != null)
                   stmt.close();
                if (con != null)
                   con.close();
             } catch (Exception e3) {
                // TODO: handle exception
             }
      */
          }
        	
        } 
    }
});
 	
 }
 public void conDB() {
     try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        //System.out.println("드라이버 로드 성공");
        txtStatus.append("드라이버 로드 성공...\n");
     } catch (ClassNotFoundException e) {
        e.printStackTrace();
     }
     
     try { /* 데이터베이스를 연결하는 과정 */
         //System.out.println("데이터베이스 연결 준비...");
   	  txtStatus.append("데이터베이스 연결 준비...\n");
         con = DriverManager.getConnection(url, userid, pwd);
         //System.out.println("데이터베이스 연결 성공");
         txtStatus.append("데이터베이스 연결 성공...\n");
      } catch (SQLException e1) {
         e1.printStackTrace();
      }
  }

 @Override
 public void actionPerformed(ActionEvent e) {
	 try {
         stmt = con.createStatement();
         
         //검색
         if (e.getSource() ==  BtnShowCourse) {//--------------------------------------------------------------------------------------
        	 
        	 
             String str1 = Tyear.getText();
             boolean isNumeric = true;
             for (int i = 0; i < str1.length(); i++) {
                 if (!Character.isDigit(str1.charAt(i))) {
                     isNumeric = false;
                 }
             }
             
             String str2 = Tsemester.getText();
             boolean isNumeric2 = true;
             for (int i = 0; i < str2.length(); i++) {
                 if (!Character.isDigit(str2.charAt(i))) {
                     isNumeric2 = false;
                 }
             }
        	 
             DefaultListModel listModel = new DefaultListModel();
        	 
        	 
        	 if(isNumeric && isNumeric2 && str1.length()>=1 && str2.length()>=1) {
        		
        	 
        	 
        	 String query = "select * from course,course_history,professor \r\n"
                     + "where professorid = professor_professorid and courseid = "
                     + "course_courseid and number in (select number from course_history "
                     + "where (professor_professorid= " + Integer.parseInt(getTitle())  + " and year= " +Integer.parseInt(Tyear.getText()) +" and semester= "+Integer.parseInt(Tsemester.getText())+" ));";
                                       
              
               /*
               String query = "select * from course where courseid in "
                     + "(select course_courseid from course_history where (student_studentid=" + Integer.parseInt(id.getText()) + " and year=" + Integer.parseInt(year.getText()) +" and semester=" + Integer.parseInt(semester.getText())  +"));";            
   */
               
               listModel.addElement("강좌번호    분반번호    강좌이름             "
               		+ "강의요일    강의교시    취득학점(1~4)    강좌시간(1~6)                   개설학과                   강의실 정보                   강의하는 교수\n");
               
               int cnt=0;
               
                rs = stmt.executeQuery(query);
                while (rs.next()) {
                   String str =  rs.getInt(1) + "                " + rs.getInt(2) + "            " + rs.getString(3) + "        "+"        "+
                              rs.getString(4) + "                " + rs.getInt(5) + "                       " + rs.getInt(6) + "      "
                              		+ "                         "+
                              rs.getInt(7) + "                       " + rs.getString(8) + "               " + rs.getString(9) + "                       "+ rs.getString(25) + "        "+
                               "\n";
                   listModel.addElement(str);
                   cnt++;
                }
                if(cnt>0) {
                	list.setModel(listModel);
                }
                else {
                	DefaultListModel listModel2 = new DefaultListModel();
                	listModel2.addElement("해당학기의 내역이 없습니다.");
                	list.setModel(listModel2);
                }
                
        	 }
        	 else {
        		 listModel.addElement("숫자를 입력해 주세요.");
        		 list.setModel(listModel);
        	 }
                
         }
       //검색
         if (e.getSource() == BtnBelong) {
      	      DefaultListModel listModel = new DefaultListModel();
        	 
             String query = "select * from dept where deptid in (select Dept_deptid from belong where professor_professorid= " + Integer.parseInt(getTitle()) +");";
             listModel.addElement("학과번호               학과명                학과전화번호              학과사무실          학과장번호");
             //txtResult.setText("\n");
             rs = stmt.executeQuery(query);
             while (rs.next()) {
                String str = rs.getInt(1) + "                      " + rs.getString(2) + "          " + rs.getString(3) + "          "+
                         rs.getString(4) + "          " + rs.getInt(5) + "\t"+
                      "\n";
                listModel.addElement(str);
              }

             list.setModel(listModel);


         }
         if (e.getSource() == Cancel) {//--------------------------------------------------------------------------------------------------------------------
        	 TargetS.setText("");
        	 TargetG.setText("");
         }
         if (e.getSource() == Cancel2) {//--------------------------------------------------------------------------------------------------------------------
        	 Tyear.setText("");
        	 Tsemester.setText("");
         }

       //검색
         if (e.getSource() == BtnSchedule) {
        	 
        	 
        	 
        	 
        	 
        	 
        	 
        	 
        	 
        	 
        	 
        	 
             //화면 바꾸기.
        	 String[] SList = new String[999];
        	 
        	 String query = "select * from course,course_history,professor \r\n"
                     + "where professorid = professor_professorid and courseid = "
                     + "course_courseid and number in (select number from course_history "
                     + "where (professor_professorid= " + Integer.parseInt(getTitle())  + " and year= " +2021 +" and semester= "+1+" ));";
                                       
              
               /*
               String query = "select * from course where courseid in "
                     + "(select course_courseid from course_history where (student_studentid=" + Integer.parseInt(id.getText()) + " and year=" + Integer.parseInt(year.getText()) +" and semester=" + Integer.parseInt(semester.getText())  +"));";            
   */		
               
        	 int cnt = 0;
                rs = stmt.executeQuery(query);
                while (rs.next()) {
                   String str =  rs.getInt(1) + "                " + rs.getInt(2) + "            " + rs.getString(3) + "        "+"        "+
                              rs.getString(4) + "                " + rs.getInt(5) + "                       " + rs.getInt(6) + "      "
                              		+ "                         "+
                              rs.getInt(7) + "                       " + rs.getString(8) + "               " + rs.getString(9) + "                       "+ rs.getString(25) + "        "+
                               "\n";
                   SList[cnt] = rs.getString(3) +  " " + rs.getString(4) + " " + rs.getString(5) + " " + rs.getString(7)+ " ";
                   cnt++;
                }
                String tmp = new String();
                
                tmp = " ";
                for(int i=0;i<cnt;i++) {
             	   
             	   tmp = tmp + SList[i];
                }
        	 
             ps = new Pschedule(tmp);
             
             
             
             
         	
             
             
             
             
             
             
             
             
             
             
             
             
         }
         //검색
         if (e.getSource() == BtnNowCourse) {

    	      DefaultListModel listModel = new DefaultListModel();
    	      
        	 boolean flag = false;
        	 String a = "select professor_professorid from course_history where year=2021 and semester = 1;";
        	 
        	 rs = stmt.executeQuery(a);
             while (rs.next()) {
                if(getTitle().equals(rs.getString(1))) {
                	flag=true;
                	break;
                }
              }
             if(flag==false) {
                 listModel.addElement("현재학기의 가르치는 과목이 없습니다.");//요소 추가
                 list.setModel(listModel);
             }
        	 
             else {
            	 
            	 
                 String str1 = TargetS.getText();
                 boolean isNumeric = true;
                 for (int i = 0; i < str1.length(); i++) {
                     if (!Character.isDigit(str1.charAt(i)) ) {
                         isNumeric = false;
                     }
                 }
            	 if(str1.length()<1)
            		 isNumeric = false;
            	 
                 String str2 = TargetG.getText();
                 boolean Score = false;
                 if(str2.equals("A+")||str2.equals("A0")||str2.equals("B+")||str2.equals("B0")||str2.equals("C+")||str2.equals("C0")||str2.equals("D+")||str2.equals("D0")||str2.equals("F")) {
                	 Score = true;
                 }
                 if(isNumeric == false && Score == false) {
                	 listModel.addElement("학생은 학번(숫자)형식으로 입력해야하고, 성적은 (A+,A0,B+,B0,C+,C0,D+,D0,F) 중 하나를 입력해야합니다.");//요소 추가
                     list.setModel(listModel);
                 }
                 
                 else if(isNumeric==false) {
                     listModel.addElement("학생은 학번(숫자)형식으로 입력해야합니다.");//요소 추가
                     list.setModel(listModel);

            	 }
            	 else if(Score == false) {
                     listModel.addElement("성적은 (A+,A0,B+,B0,C+,C0,D+,D0,F) 중 하나를 입력해야합니다.");//요소 추가
                     list.setModel(listModel);
            	 }
            	 else {
            		 
            		 
            		 
                	 String tmp = "select studentid from student;";
                	 boolean flag2 = false;
                	 rs = stmt.executeQuery(tmp);
                     while (rs.next()) {
                        if(TargetS.getText().equals(rs.getString(1))) {
                        	
                        	flag2=true;
                        	break;
                        }
                      }
            		 
            		 
            	 if(flag2 == true) {
		             String query = "update course_history set average_score='" + TargetG.getText() + "' "
		                     + "where( year=2021 and semester=1 and professor_professorid= " +  Integer.parseInt(getTitle()) +" and student_studentid= " +  Integer.parseInt(TargetS.getText()) + ");";
		                stmt.executeUpdate(query);
		              listModel.addElement("선택한 학생의 성적이 입력되었습니다.");//요소 추가
		              list.setModel(listModel);
		              }
            	 else {
          		    listModel.addElement("해당 학번은 없는 학번입니다.");//요소 추가
          		    list.setModel(listModel);
 
             	 }
            	 
            	 
            	 
            	 
            	 }
            	 
            	 
            	 
             }

         }
         //검색
         if (e.getSource() == BtnStudent) {
        	 DefaultListModel listModel = new DefaultListModel();
             String query = "select * from student where professorid = "+Integer.parseInt(getTitle())+ ";";
             listModel.addElement("학생번호      학생이름                       주소                       "
             		+ "                전화번호                       "
             		+ "                 e-mail                       "
             		+ "          학년        학기          담당교수번호     부전공번호     등록금계좌번호     전공번호");
               //txtResult.setText("학생번호\t");
             //txtResult.setText("\n");
             rs = stmt.executeQuery(query);
             while (rs.next()) {
                String str = rs.getInt(1) + "     " + rs.getString(2) + "     " + rs.getString(3) + "     "+
                      rs.getString(4) + "     " + rs.getString(5) + "         " + rs.getInt(6) + "            "+
                      rs.getInt(7) + "               " + rs.getInt(8) + "                " + rs.getInt(9) + "                 "+
                      rs.getString(10) + "             " + rs.getInt(11) + "     "+
                          "\n";
                listModel.addElement(str);
              }

             list.setModel(listModel);
         }


         
      } catch (Exception e2) {
         //txtResult.setText("");
         //txtResult.setText("쿼리 읽기 실패 :" + e2);
/*      } finally {
         try {
            if (rs != null)
               rs.close();
            if (stmt != null)
               stmt.close();
            if (con != null)
               con.close();
         } catch (Exception e3) {
            // TODO: handle exception
         }
  */
      }
}
 }
 
 
 




//-----------------------------------------------------------------------------------------------------------------------------학생 Frame

class SFrame extends JFrame implements ActionListener{
	Sschedule ss;
	   static Connection con;
	   Statement stmt;
	   ResultSet rs;
	   String Driver = "";
	   String url = "jdbc:mysql://localhost:3306/madang?&serverTimezone=Asia/Seoul&useSSL=false";
	   String userid = "madang";
	   String pwd = "madang";

	JButton BtnCourse;
	JButton BtnSchedule;
	JButton BtnBelong;
	JButton BtnGrade;
	
	Container a = getContentPane();
	   JTextField Tyear;
	   JTextField Tsemester;
	   JTextArea txtResult, txtStatus;
	   
	JPanel N;
	
    public SFrame(String S){
        super(S);
        layInit();
        conDB();
        setVisible(true);
        setTitle(S);

        setBounds(200, 200, 800, 500); //가로위치,세로위치,가로길이,세로길이
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public void layInit() {
    	txtResult = new JTextArea();
    	txtStatus = new JTextArea(5,30);
    	
    	N = new JPanel();
    	a.setLayout(new BorderLayout());
    	Tyear = new JTextField(20);
    	Tsemester = new JTextField(20);
    	
    	
	      JScrollPane scrollPane = new JScrollPane(txtResult);
	      JScrollPane scrollPane2 = new JScrollPane(txtStatus);
	      
	      
	      JPanel N1 = new JPanel();
	      JPanel N2 = new JPanel();
	      JPanel N3 = new JPanel();
	      
	  	BtnCourse = new JButton("수강하는 과목");
		BtnSchedule = new JButton("시간표");
		BtnBelong = new JButton("소속동아리");
		BtnGrade = new JButton("성적표 출력");
		
	      	N1.add( new JLabel("학생님 환영합니다! "+getTitle()+"님"));
	    	N2.add(new JLabel("년도"));
	    	N2.add(Tyear);
	    	N2.add(new JLabel("학기"));
	    	N2.add(Tsemester);
	    	
	    	N2.add(BtnCourse);
	      
	    	
	    	N3.add(BtnSchedule);
	    	N3.add(BtnBelong);
	    	N3.add(BtnGrade);
	    	
	      N.setLayout(new GridLayout(3,1));
	      
	      
	      
	      N.add(N1);
	      N.add(N2);
	      N.add(N3);
	      
	      
    	
    	
    	
    	a.add("North",N);
	      txtResult.setEditable(false);
	      txtStatus.setEditable(false);
	      
	      a.add("Center", scrollPane);
	      a.add("South", scrollPane2);  
	      
	      
	      BtnCourse.addActionListener(this);
	      BtnSchedule.addActionListener(this);
	      BtnBelong.addActionListener(this);
	      BtnGrade.addActionListener(this);
	      
    	
    }
    public void conDB() {
        try {
           Class.forName("com.mysql.cj.jdbc.Driver");
           //System.out.println("드라이버 로드 성공");
           txtStatus.append("드라이버 로드 성공...\n");
        } catch (ClassNotFoundException e) {
           e.printStackTrace();
        }
        
        try { /* 데이터베이스를 연결하는 과정 */
            //System.out.println("데이터베이스 연결 준비...");
      	  txtStatus.append("데이터베이스 연결 준비...\n");
            con = DriverManager.getConnection(url, userid, pwd);
            //System.out.println("데이터베이스 연결 성공");
            txtStatus.append("데이터베이스 연결 성공...\n");
         } catch (SQLException e1) {
            e1.printStackTrace();
         }
     }

    @Override
    public void actionPerformed(ActionEvent e) {
   	 try {
            stmt = con.createStatement();
            
            //검색
            if (e.getSource() ==  BtnCourse) {//--------------------------------------------------------------------------------------
            	
            	String id = getTitle();
           	 
           	 	if(id.contains("*")){
           		 	id = id.substring(0,id.length()-1);
           	 	}
            	
                String query = "select * from course,course_history,professor \r\n"
                        + "where professorid = professor_professorid and courseid = "
                        + "course_courseid and number in (select number from course_history "
                        + "where (student_studentid= " + Integer.parseInt(id)  + " and year= " +Integer.parseInt(Tyear.getText()) +" and semester= "+Integer.parseInt(Tsemester.getText())+" ));";
                                          
                 
                  /*
                  String query = "select * from course where courseid in "
                        + "(select course_courseid from course_history where (student_studentid=" + Integer.parseInt(id.getText()) + " and year=" + Integer.parseInt(year.getText()) +" and semester=" + Integer.parseInt(semester.getText())  +"));";            
      */
                  
                int cnt=0;
                  txtResult.setText("");
                  txtResult.setText("강좌번호\t분반번호\t강좌이름\t강의요일\t강의교시\t취득학점(1~4)\t강좌시간(1~6)\t개설학과\t강의실 정보\t강의하는 교수\n");
                   rs = stmt.executeQuery(query);
                   while (rs.next()) {
                      String str = rs.getInt(1) + "\t" + rs.getInt(2) + "\t" + rs.getString(3) + "\t"+
                                 rs.getString(4) + "\t" + rs.getInt(5) + "\t" + rs.getInt(6) + "\t"+
                                 rs.getInt(7) + "\t" + rs.getString(8) + "\t" + rs.getString(9) + "\t"+ rs.getString(25) + "\t"+
                                  "\n";
                      txtResult.append(str);
                      cnt++;
                   }
                   if(cnt<1) {
                	   txtResult.setText("");
                	   txtResult.setText("해당학기에 수강한 과목이 없습니다.");
                   }

           	 
            }
          //검색
            if (e.getSource() == BtnBelong) {
            	 int i=0;
                 //20010989
            	 String id = getTitle();
            	 
            	 if(id.contains("*")){
            		 i = 1;
            		 id = id.substring(0,id.length()-1);
            	 } 	 
            	 else
            		 i = 0;
            	 
            	 
                 if(i==1) {//동아리 회장일 때 학생정보 출력
                    String query = " select * from student "
                       + "where studentid in "
                       + "(select student_studentid from join_club "
                       + "where club_clubid in (select clubid from club where president ="+ Integer.parseInt(id) + "));";
                     txtResult.setText("");
                     txtResult.setText("학생번호\t학생이름\t주소\t학생이름\t전화번호\te-mail\t학년\t학기\t담당교수번호\t부전공번호\t등록금계좌번호\t전공번호\n");

                     rs = stmt.executeQuery(query);
                     while (rs.next()) {
                         String str = rs.getInt(1) + "\t" + rs.getString(2) + "\t" + rs.getString(3) + "\t"+
                              rs.getString(4) + "\t" + rs.getString(5) + "\t" + rs.getInt(6) + "\t"+
                              rs.getInt(7) + "\t" + rs.getInt(8) + "\t" + rs.getInt(9) + "\t"+
                              rs.getString(10) + "\t" + rs.getInt(11) + "\t"+
                                  "\n";
                         txtResult.append(str);
                      }
                 }
                 
                 else {// 동아리 회장이 아닐 때 속한 동아리 정보 출력
                     String query = " select clubid,name,room,president,professor_professorid,count(clubid)"
                           + " from club where clubid in "
                           + "(select club_clubid from join_club where student_studentid= " + Integer.parseInt(id) + ");";                     
                        txtResult.setText("");
                        txtResult.setText("동아리번호\t동아리이름\t동아리방\t학생회장번호\t담당교수번호\t동아리원 수\n");

                         rs = stmt.executeQuery(query);
                         while (rs.next()) {
                             String str =rs.getInt(1) + "\t" + rs.getString(2) + "\t" + rs.getString(3) + "\t"+
                                      rs.getInt(4) + "\t" + rs.getInt(5) + "\t" + rs.getInt(6) + "\t"+
                                       "\n";
                             txtResult.append(str);
                          }   
                     
                 }


            }

          //검색
            if (e.getSource() == BtnSchedule) {
            	
            	

                
            	String[] SList = new String[999];
            	
            	
            	String id = getTitle();
              	 
           	 	if(id.contains("*")){
           		 	id = id.substring(0,id.length()-1);
           	 	}
            	
                String query = "select * from course,course_history,professor \r\n"
                        + "where professorid = professor_professorid and courseid = "
                        + "course_courseid and number in (select number from course_history "
                        + "where (student_studentid= " + Integer.parseInt(id)  + " and year= " + 2021 +" and semester= "+ 1 +" ));";
                                          
                 
                  /*
                  String query = "select * from course where courseid in "
                        + "(select course_courseid from course_history where (student_studentid=" + Integer.parseInt(id.getText()) + " and year=" + Integer.parseInt(year.getText()) +" and semester=" + Integer.parseInt(semester.getText())  +"));";            
      */
                  int cnt = 0;
                   rs = stmt.executeQuery(query);
                   while (rs.next()) {
                	   
                      String str = rs.getInt(1) + "\t" + rs.getInt(2) + "\t" + rs.getString(3) + "\t"+
                                 rs.getString(4) + "\t" + rs.getInt(5) + "\t" + rs.getInt(6) + "\t"+
                                 rs.getInt(7) + "\t" + rs.getString(8) + "\t" + rs.getString(9) + "\t"+ rs.getString(25) + "\t"+
                                  "\n";
                      SList[cnt] = rs.getString(3) +  " " + rs.getString(4) + " " + rs.getString(5) + " " + rs.getString(7)+ " ";
                      cnt++;
                   }
                   
                   
                   String tmp = new String();
                   
                   tmp = " ";
                   for(int i=0;i<cnt;i++) {
                	   
                	   tmp = tmp + SList[i];
                   }
                   tmp = tmp;
                   ss = new Sschedule(tmp);
            	
            	
            	
            	
            	
            	
            	
            	
            	
            	
            }
            //검색
            if (e.getSource() == BtnGrade) {
                String id = getTitle();
              	 
           	 	if(id.contains("*")){
           		 	id = id.substring(0,id.length()-1);
           	 	}

                String query = "select number,name,course.get_grade,average_score "
                      + "from course_history,course where courseid = course_courseid and (student_studentid= " + id  + " and year=2021 and semester=1);";
                 txtResult.setText("");
                 txtResult.setText("과목번호\t과목명\t취득학점\t평점\n");
                 double GPA =0.0;
                 
                 int cnt=0;
                 rs = stmt.executeQuery(query);
                 while (rs.next()) {
                     String str = rs.getInt(1) + "\t" + rs.getString(2) + "\t" + rs.getString(3) + "\t"+
                          rs.getString(4)+"\n";
                    
                        cnt++;
                        if (rs.getString(4).equals("A+")) {
                           GPA += 4.5;
                        }
                        else if(rs.getString(4).equals("A0")) {
                           GPA += 4.0;
                        }
                        else if(rs.getString(4).equals("B+")) {
                           GPA += 3.5;
                        }
                        else if(rs.getString(4).equals("B0")) {
                           GPA += 3.0;
                        }
                        else if(rs.getString(4).equals("C+")) {
                           GPA += 2.5;
                        }
                        else if(rs.getString(4).equals("C0")) {
                           GPA += 2.0;
                        }
                        else if(rs.getString(4).equals("D+")) {
                           GPA += 1.5;
                        }
                        else if(rs.getString(4).equals("D0")) {
                           GPA += 1.0;
                        }
                           
                    
                     
                     txtResult.append(str);
                  }
                 
                 GPA/=(double)cnt;
                 txtResult.append("이번 학기 GPA : "+Double.toString(GPA));



            }

            
         } catch (Exception e2) {
            //txtResult.setText("");
            //txtResult.setText("쿼리 읽기 실패 :" + e2);
   /*      } finally {
            try {
               if (rs != null)
                  rs.close();
               if (stmt != null)
                  stmt.close();
               if (con != null)
                  con.close();
            } catch (Exception e3) {
               // TODO: handle exception
            }
     */
         }
   }
    
    
    
}


public class JC17011548M1 extends JFrame implements ActionListener {
	SFrame sf;
	PFrame pf;
	RFrame rf;
	SubFrame error;
	
	   JTextArea txtStatus;
	   JPanel LoginPn;
	   JTextField id;
	   JButton P,S,R;
	   Container c = getContentPane();

   
   static Connection con;
   Statement stmt;
   ResultSet rs;
   String Driver = "";
   String url = "jdbc:mysql://localhost:3306/madang?&serverTimezone=Asia/Seoul&useSSL=false";
   String userid = "madang";
   String pwd = "madang";

   public JC17011548M1() {
      super("Swing Database");
      layInit();
      conDB();
      setVisible(true);
      setTitle("17011548 홍수민 17011593 박윤환");
      setBounds(200, 200, 300, 300); //가로위치,세로위치,가로길이,세로길이
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   }

   public void layInit() {
	      txtStatus = new JTextArea(5,30);
	      LoginPn = new JPanel();
	      
	      id = new JTextField(20);
	      P = new JButton("교수");
	      S = new JButton("학생");
	      R = new JButton("관리자");
	      
	      LoginPn.setLayout(new FlowLayout());
	      LoginPn.add(id);
	      LoginPn.add(P);
	      LoginPn.add(S);
	      LoginPn.add(R);
	      	      

	      JScrollPane scrollPane2 = new JScrollPane(txtStatus);
	      c.add("North", new JLabel("본인의 아이디를 입력하세요.(관리자 : root)"));
	      c.add("Center",LoginPn);
	      //c.add("West", scrollPane);
	      c.add("South", scrollPane2);
	      
	      
	      txtStatus.setEditable(false);
	      
	      P.addActionListener(this);
	      S.addActionListener(this);
	      R.addActionListener(this);
	      
	      
	      
	      
   }

   public void conDB() {
      try {
         Class.forName("com.mysql.cj.jdbc.Driver");
         //System.out.println("드라이버 로드 성공");
         txtStatus.append("드라이버 로드 성공...\n");
      } catch (ClassNotFoundException e) {
         e.printStackTrace();
      }
      
      try { /* 데이터베이스를 연결하는 과정 */
          //System.out.println("데이터베이스 연결 준비...");
    	  txtStatus.append("데이터베이스 연결 준비...\n");
          con = DriverManager.getConnection(url, userid, pwd);
          //System.out.println("데이터베이스 연결 성공");
          txtStatus.append("데이터베이스 연결 성공...\n");
       } catch (SQLException e1) {
          e1.printStackTrace();
       }
   }


   @Override
   public void actionPerformed(ActionEvent e) {
    
      try {
         stmt = con.createStatement();
         
         //검색
         if (e.getSource() == S) {
        	 
        	 try {
			        	 String tmp = "";
			       	  String query = "SELECT studentid FROM student;";
			       	  rs = stmt.executeQuery(query);
			          while (rs.next()) {
			                 if(Integer.valueOf(id.getText()) == rs.getInt(1)) {
			               	  //화면 바꾸기.
			                  	  query = "select president from club;";
			                   	  rs = stmt.executeQuery(query);
			                      while (rs.next()) {
			                             if(Integer.valueOf(id.getText()) == rs.getInt(1)) {
			                           	  //화면 바꾸기.
			                            	 tmp = "*";
			                           	  break;
			                             }
			                             
			                          }
			               	  sf = new SFrame(id.getText()+tmp);
			               	  break;
			                 }
			                 
			              }
			         }
        	 catch(Exception e2) {
        		 error = new SubFrame("학생");
        	 }
         }
         
         
       //검색
         if (e.getSource() == P) {
        	 
        	 try {
	       	  String query = "select professorid from professor;";
	       	  rs = stmt.executeQuery(query);
	          while (rs.next()) {
	                 if(Integer.valueOf(id.getText()) == rs.getInt(1)) {
	               	  //화면 바꾸기.
	               	  pf = new PFrame(id.getText());
	               	  break;
	                 }
	                 
	              }
        	 }
        	 catch(Exception e2) {
        		 error = new SubFrame("교수");
        	 }
             
         }

       //검색
         if (e.getSource() == R) {
             if(id.getText().equals("root")) {
              	  //화면 바꾸기.
              	  rf = new RFrame(id.getText());
             }
             else {
            	 error = new SubFrame("관리자");
             }
         }

         
         
         
         
         
         
      } catch (Exception e2) {
    	  
         //txtResult.setText("");
         //txtResult.setText("쿼리 읽기 실패 :" + e2);
/*      } finally {
         try {
            if (rs != null)
               rs.close();
            if (stmt != null)
               stmt.close();
            if (con != null)
               con.close();
         } catch (Exception e3) {
            // TODO: handle exception
         }
  */
      }

   }
   
   
   public static void main(String[] args) {
	   JC17011548M1 BLS = new JC17011548M1();
      
      //BLS.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
      //BLS.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      
      BLS.addWindowListener(new WindowAdapter() {
    	  public void windowClosing(WindowEvent we) {
    		try {
    			con.close();
    		} catch (Exception e4) { 	}
    		System.out.println("프로그램 완전 종료!");
    		System.exit(0);
    	  }
    	});
   }
}

/*
public class JC17011548M1_2 extends JFrame implements ActionListener {
	   JTextArea txtResult, txtStatus;
	   JPanel LoginPn,Professor,pnN,pnW;
	   JTextField id;
	   JButton P,S,R;
	   Container c = getContentPane();

static Connection con;
Statement stmt;
ResultSet rs;
String Driver = "";
String url = "jdbc:mysql://localhost:3306/madang?&serverTimezone=Asia/Seoul&useSSL=false";
String userid = "madang";
String pwd = "madang";

public JC17011548M1() {
   super("Swing Database");
   layInit();
   conDB();
   setVisible(true);
   setTitle("17011548 홍수민");
   setBounds(200, 200, 300, 500); //가로위치,세로위치,가로길이,세로길이
   setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
}

public void layInit() {
	      
	      
	      
	      
}
}

---------------------------------





*/