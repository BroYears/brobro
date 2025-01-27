package com.system.restaurant.employee;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class EmployeeService {

	// 데이터들을 순서에 맞게 저장할 객체 리스트
	public static ArrayList<User> Users;

	// 최대 직원수를 Count 하는 변수
	public static int employeeMaxCount = 0;

	// employeeData데이터 더미 텍스트 파일 경로
	private final static String employeeData_PATH;

	// Employee 와 Manager 객체중 선택할 때 필요한 변수
	public final static String employeeType1;
	public final static String employeeType2;

	// static 영역
	static {
		employeeData_PATH = "C:\\Users\\user\\Desktop\\BistroMaster_우현\\src\\직원데이터\\employeeData.txt";
		Users = new ArrayList<>();
		employeeType1 = new String("매니저");
		employeeType2 = new String("사원");
	}

	// 1~6번 직원 정보 확인용
	public static void showEmployeeInfos(int mainInput) {
		int subInput = showEmployeeInfo(mainInput);
		if (subInput == 1) {
			mainInput = employeeEdit(mainInput);
			save();
		} else {
			System.out.println("번호를 잘못 입력하였습니다. ");
			return;
		}
	}

	public static void employeeLoad() {

		if (Users.isEmpty()) {
			String line = null;
			employeeMaxCount = 0;

			BufferedReader reader = null;
			try {
				reader = new BufferedReader(new FileReader(employeeData_PATH));

				String name;
				String type1;
				String phoneNumber;
				String hireDate;
				String type2;

				int no = 0;
				int payment = 0;

				// 텍스트 파일에 있는 내용을 객체 옮기기
				while ((line = reader.readLine()) != null) {
					String[] temp = line.split(",");

					no = Integer.parseInt(temp[0]);
					name = temp[1];
					type1 = temp[2];
					phoneNumber = temp[3];
					hireDate = temp[4];

					payment = Integer.parseInt(temp[5]);
					type2 = temp[6];

					objectCreate(no, name, type1, phoneNumber, hireDate, payment, type2);
					// 직책에 따라 Manager/Employee 객체로 생성 후 set 리스트에 추가
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	private static void objectCreate(int no, String inputName, String selectType, String inputPhoneNumber,
			String inputHireDate, int inputPayment, String inputContractType) {

		if (selectType.equals(employeeType1)) {

			Users.add(new Manager(no, inputName, selectType, inputPhoneNumber, inputHireDate, inputPayment,
					inputContractType));
			employeeMaxCount++;

		} else if (selectType.equals(employeeType2)) {

			Users.add(new Employee(employeeMaxCount + 1, inputName, selectType, inputPhoneNumber, inputHireDate,
					inputPayment, inputContractType));
			employeeMaxCount++;

		} else {
			System.out.printf(" %s 란 직책은 없습니다.", selectType);
			System.out.println("인력 추가를 취소합니다.");
		}

	}

	public static void save() {
		// Arraylist<Memo> memo.txt
		try {

			BufferedWriter writer = new BufferedWriter(new FileWriter(employeeData_PATH));

			for (User user : Users) {

				try {
					writer.write(
							String.format("%d,%s,%s,%s,%s,%d,%s \r\n", user.getNo(), user.getName(), user.getType1(),
									user.getPhoneNumber(), user.getHireDate(), user.getPayment(), user.getType2()));
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}

			writer.close();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}// save

	// 인력추가하는 메소드
	public static void employeeAdd() {

		String inputName;
		String selectType;
		String inputPhoneNumber;
		String inputHireDate;
		int inputPayment;
		String inputContractType;

		System.out.printf("\t\t 직원 추가");
		System.out.println();
		System.out.println("============================================================");
		System.out.println();

		inputName = setScanName();
		selectType = setScanEmpType();
		inputPhoneNumber = setScanPhoneNum();
		inputHireDate = setScanEnterDate();
		inputPayment = checkEmployeeType(selectType);
		inputContractType = setScanContractType();

		System.out.println();
		System.out.println("============================================================");

		objectCreate(employeeMaxCount + 1, inputName, selectType, inputPhoneNumber, inputHireDate, inputPayment,
				inputContractType);

	}

	// 선택한 직원 정보를 보여주고 다음 행동을 반환하는 메소드
	protected static int showEmployeeInfo(int no) {
		int returnNum = -1;
		Scanner scan = new Scanner(System.in);

		for (User user : Users) {
			if (user.getNo() == no) {
				System.out.printf("\t\t %s(%s)", user.getName(), user.getType1());
				System.out.println();
				System.out.println("============================================================");
				System.out.println();
				System.out.printf("- 이름 : %s\n", user.getName());
				System.out.printf("- 연락처 : %s\n", user.getPhoneNumber());
				System.out.printf("- 입사일 : %s (%s)\n", user.getHireDate(), user.getType2());
				System.out.printf("- 직급 : %s\n", user.getType1());
				System.out.printf("- 시급 : %s\n", user.getPayment());
				System.out.println();
				System.out.println("============================================================");
			}
		}

		System.out.println("(수정하기 1번/ 초기화면 0번): ");
		returnNum = Integer.parseInt(scan.nextLine());

		return returnNum;

		// 오류 발생시 저장하지 않고 인력관리 메인창으로 돌아간다.

	}

	// 인력내용 수정하는 메소드
	private static int employeeEdit(int no) {

		Scanner scan = new Scanner(System.in);
		String[] stringEdit = new String[6];
		int editInput = -1;

		System.out.println("\t\t 인력수정(매니저/직원)");
		System.out.println();
		System.out.println("============================================================");
		System.out.println();

		stringEdit[0] = setScanName();
		stringEdit[1] = setScanPhoneNum();
		stringEdit[2] = setScanEnterDate();
		stringEdit[3] = setScanEmpType();
		stringEdit[4] = setScanTimeFee();
		stringEdit[5] = setScanContractType();

		System.out.println();
		System.out.println("============================================================");
		System.out.println("수정하시겠습니까? 1번/ 아니요? 9번 / 취소하고 초기화면 나가려면 0번");

		editInput = Integer.parseInt(scan.nextLine());
		if (editInput == 0) {
			return 0;

		} else if (editInput == 1) {
			for (User user : Users) {
				// 선택한 번호에 객체 선택
				if (user.getNo() == no) {

					if (!stringEdit[0].isEmpty()) {
						user.setName(stringEdit[0]);
					} else {
						System.out.println("이름칸 내용이 비어있습니다.");
					}

					if (!stringEdit[1].isEmpty()) {
						user.setPhoneNumber(stringEdit[1]);
					} else {
						System.out.println("폰 번호 내용이 비어있습니다.");
					}

					if (!stringEdit[2].isEmpty()) {
						user.setHireDate(stringEdit[2]);
					} else {
						System.out.println("입사일 내용이 비어있습니다.");
					}

					if (!stringEdit[3].isEmpty()) {
						user.setType1(stringEdit[3]);
					} else {
						System.out.println("시급 내용이 비어있습니다.");
					}

					if (!stringEdit[4].isEmpty()) {
						user.setPayment(Integer.parseInt(stringEdit[4]));
					} else {
						System.out.println("계약직 내용이 비어있습니다.");
					}

				}
			}

		}
		return editInput;
	}

	// setScan 입력받을 정보를 String 반환 메소드
	private static String setScanName() {
		Scanner scan = new Scanner(System.in);
		System.out.print("이름: ");
		String getName = scan.nextLine();
		isStringEmptyCheck(getName);

		return getName;

	}

	private static String setScanPhoneNum() {
		Scanner scan = new Scanner(System.in);
		System.out.print("연락처: ");
		String getPhoneNum = scan.nextLine();
		isStringEmptyCheck(getPhoneNum);

		return getPhoneNum;

	}

	private static String setScanEnterDate() {
		Scanner scan = new Scanner(System.in);
		System.out.print("입사일: ");
		String EnterDate = scan.nextLine();
		isStringEmptyCheck(EnterDate);

		return EnterDate;

	}

	private static String setScanEmpType() {
		Scanner scan = new Scanner(System.in);
		System.out.print("직급: ");
		String EmpType = scan.nextLine();
		isStringEmptyCheck(EmpType);

		return EmpType;

	}

	private static String setScanTimeFee() {
		Scanner scan = new Scanner(System.in);
		System.out.print("시급: ");
		String TimeFee = scan.nextLine();
		isStringEmptyCheck(TimeFee);

		return TimeFee;

	}

	private static String setScanContractType() {
		boolean loop = true;
		String ContractType = "";
		Scanner scan = new Scanner(System.in);

		while (loop) {
			System.out.print("정규직/계약직: ");
			ContractType = scan.nextLine();
			if (!ContractType.isEmpty()) {
				loop = false;
			}else {
				System.out.println("다시 입력하세요.");
			}
		}
		
		return ContractType;
	}
		

	private boolean isStringEmpty(String str) {
		return str == null || str.isBlank();
	}

	// 빈공간 있으면 오류내용 출력하고 다음으로 넘어가는 메소드
	private static void isStringEmptyCheck(String str) {
		if (str.isBlank()) {
			throw new IllegalArgumentException("빈 공간이 있습니다.");
		}
	}

	// <직원 정보 추가>직책이 매니저인지 사원인지 확인하고 임금을 결정하는 메소드
	private static int checkEmployeeType(String EmployeeType) {
		Scanner scan = new Scanner(System.in);
		String inputPayment = "";
		int returnPayment2;

		if (EmployeeType.equals(employeeType1)) {
			System.out.printf("월급 입력: ");
			inputPayment = scan.nextLine();

		} else if (EmployeeType.equals(employeeType2)) {
			System.out.printf("시급 입력: ");
			inputPayment = scan.nextLine();

		}
		isStringEmptyCheck(inputPayment);
		returnPayment2 = Integer.parseInt(inputPayment);
		return returnPayment2;

	}

	public static int remove() {
		Scanner scan = new Scanner(System.in);

		int removerNum = 0;

		System.out.println();
		System.out.println("============================================================");
		System.out.println();
		System.out.println("삭제할 번호를 고르세요. / 초기화면 0번");

		removerNum = Integer.parseInt(scan.nextLine());

		if (removerNum > 0) {
			for (User user : Users) {

				if (user.getNo() == removerNum) {
					Users.remove(user); // 해당 번호 데이터는 완전 삭제

					for (int j = removerNum - 1; j < Users.size(); j++) {
						// 그냥 user 객체를 사용해 no를 변경
						Users.get(j).setNo(Users.get(j).getNo() - 1); // 사용자 번호 감소
					}
					break;
				}
			}

		} else if (removerNum == 0) {
			return 0;
		}
		return removerNum;

	}

}
