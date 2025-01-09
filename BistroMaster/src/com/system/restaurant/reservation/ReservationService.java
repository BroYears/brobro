package com.system.restaurant.reservation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;

import com.system.restaurant.view.ReservationView;

public class ReservationService {
	
	private final static String PATH;
	public static ArrayList<Reservation> rlist;
	private static Scanner scan;
	
	static {
		PATH = ".\\data\\예약\\예약 더미데이터.txt";
		rlist = new ArrayList<>();
		scan = new Scanner(System.in);
	}
	
	public static int getMaxNo() {
        int maxNo = 0;
        for (Reservation reservation : rlist) {
            if (reservation.getNo() > maxNo) {
                maxNo = reservation.getNo();
            }
        }
        return maxNo;
    }
	
	public static void reservationAdd() {
		
		Scanner scan = new Scanner(System.in);
		
		try {
			int no = getMaxNo() + 1; // 고유 번호 생성
		
            String name = getName();
            String phoneNumber = getPhoneNumber();
            String dateTime = getDateTime();
            int number = getNumber();
		

	    	// 새 예약 추가
	    	rlist.add(new Reservation(no, name, phoneNumber, dateTime, number));

	    	System.out.println();
	    	System.out.println("예약 작성을 완료하였습니다.");
	    } catch (Exception e) {
	        System.out.println("[오류] 알 수 없는 문제가 발생했습니다. 다시 시도해주세요.");
	    }
		
		save();
		
	}//add
	
	
	
	public static void reservationList() {
		
		ReservationView.mainMenu();
		
		Scanner scan = new Scanner(System.in);
		System.out.print("확인할 날짜를 입력하세요 (예: 2025-01-08): ");
		String inputDate = scan.nextLine();
		
		ArrayList<Reservation> filteredList = new ArrayList<>();
		
		for (Reservation reservation : rlist) {
			String reservationDate = reservation.getDateTime().split(" ")[0];
			if (reservationDate.equals(inputDate)) {
				filteredList.add(reservation);
			}
		}
		
		filteredList.sort((r1, r2) -> r1.getDateTime().compareTo(r2.getDateTime())); //<-
		
	    System.out.println("===============================================================");
	    System.out.println("번호   이름         연락처           날짜                인원수");
	    System.out.println("===============================================================");
	    
	    if (filteredList.isEmpty()) {
	    	System.out.println("해당 날짜에 예약이 없습니다.");
	    	} else {
	    		for (Reservation reservation : filteredList) {
	    			System.out.printf("%-6d %-10s %-15s %-20s %d명\n",
					reservation.getNo(),
					reservation.getName(),
					reservation.getPhoneNumber(),
					reservation.getDateTime(),
					reservation.getNumber());
	    		}
	    	}
	    System.out.println("===============================================================");
	    
	}//list
	
	public static void reservationEdit() {
		
        try {
            System.out.print("번호: ");
            int seq = scan.nextInt();
            scan.nextLine(); // 버퍼 비우기

            Reservation target = findReservation(seq);

            if (target == null) {
                throw new IllegalArgumentException("해당 번호의 예약을 찾을 수 없습니다.");
            }

            // 각각의 입력 단계 호출
            String name = getName();
            String phoneNumber = getPhoneNumber();
            String dateTime = getDateTime(target.getDateTime());
            int number = getNumber();

            // 데이터 설정
            target.setName(name);
            target.setPhoneNumber(phoneNumber);
            target.setDateTime(dateTime);
            target.setNumber(number);

            System.out.println("수정이 완료되었습니다.");
        } catch (IllegalArgumentException e) {
            System.out.println("[오류] " + e.getMessage());
        } catch (Exception e) {
            System.out.println("[오류] 알 수 없는 문제가 발생했습니다. 다시 시도해주세요.");
        }
        
        save();
        
    }//edit

    private static Reservation findReservation(int seq) {
        for (Reservation rv : rlist) {
            if (rv.getNo() == seq) {
                return rv;
            }
        }
        return null;
    }

    private static String getName() {
        while (true) {
            try {
            	
                System.out.print("이름: ");
                String name = scan.nextLine();
                if (name.isEmpty()) {
                    throw new IllegalArgumentException("이름은 반드시 입력해야 합니다.");
                }
                
                if (!name.matches("^[가-힣]+$") && !name.matches("^[a-zA-Z]+$")) {
                    throw new IllegalArgumentException("이름은 한글 또는 영어로만 입력해야 하며, 혼합은 허용되지 않습니다.");
                }
                
                if (name.matches(".*\\d.*")) {
                    throw new IllegalArgumentException("이름에 숫자를 포함할 수 없습니다.");
                }
                return name;
                
            } catch (IllegalArgumentException e) {
                System.out.println("[오류] " + e.getMessage());
            }
        }
    }

    private static String getPhoneNumber() {
        while (true) {
            try {
                System.out.print("연락처: ");
                String phoneNumber = scan.nextLine();
                
                if (phoneNumber.isEmpty()) {
                    throw new IllegalArgumentException("연락처는 반드시 입력해야 합니다.");//<-
                }
                
                if (!phoneNumber.matches("\\d{3}-\\d{3,4}-\\d{4}")) {
                    throw new IllegalArgumentException("연락처 형식이 잘못되었습니다. 예: 010-1234-5678");
                }
                
                return phoneNumber;
            } catch (IllegalArgumentException e) {
                System.out.println("[오류] " + e.getMessage());
            }
        }
    }
    
    private static String getDateTime() {
        while (true) {
            try {
                System.out.print("날짜(예: 2025-01-10): ");
                String dateInput = scan.nextLine();
                
                if (dateInput.isEmpty()) {
                    throw new IllegalArgumentException("날짜 형식은 반드시 입력해야 합니다. (예: 2025-01-10)");//<-
                }
                
                if (!dateInput.matches("\\d{4}-\\d{2}-\\d{2}")) {
                    throw new IllegalArgumentException("날짜 형식이 잘못되었습니다. (예: 2025-01-10)");
                }

                System.out.print("시간(예: 15:00): ");
                String timeInput = scan.nextLine();
                
                if (timeInput.isEmpty()) {
                    throw new IllegalArgumentException("시간 형식은 반드시 입력해야 합니다. (예: 15:00)");
                }
                
                if (!timeInput.matches("\\d{2}:\\d{2}")) {
                    throw new IllegalArgumentException("시간 형식이 잘못되었습니다. 예: (15:00)");
                }

                return dateInput + " " + timeInput;
            } catch (IllegalArgumentException e) {
                System.out.println("[오류] " + e.getMessage());
            }
        }
    }

    private static String getDateTime(String currentDateTime) {
        while (true) {
            try {
                String[] dateTimeParts = currentDateTime.split(" ");
                String currentDate = dateTimeParts[0];
                String currentTime = dateTimeParts[1];

                System.out.print("입력한 날짜: " + currentDate + "): ");
                String dateInput = scan.nextLine();
                
                if (dateInput.isEmpty()) {
                    throw new IllegalArgumentException("날짜 형식은 반드시 입력해야 합니다. (예: 2025-01-10)");
                }
                
                if (!dateInput.matches("\\d{4}-\\d{2}-\\d{2}")) {
                    throw new IllegalArgumentException("날짜 형식이 잘못되었습니다. (예: 2025-01-10)");
                }

                System.out.print("입력한 시간: " + currentTime + "): ");
                String timeInput = scan.nextLine();
                
                if (timeInput.isEmpty()) {
                    throw new IllegalArgumentException("시간 형식은 반드시 입력해야 합니다. (예: 15:00)");
                }
                
                if (!timeInput.matches("\\d{2}:\\d{2}")) {
                    throw new IllegalArgumentException("시간 형식이 잘못되었습니다. 예: (15:00)");
                }

                String newDate = dateInput.isEmpty() ? currentDate : dateInput;
                String newTime = timeInput.isEmpty() ? currentTime : timeInput;
                
                return newDate + " " + newTime;
            } catch (IllegalArgumentException e) {
                System.out.println("[오류] " + e.getMessage());
            }
        }
    }

    private static int getNumber() {
        while (true) {
            try {
                System.out.print("인원수: ");	
                String numberInput = scan.nextLine();

                if (!numberInput.isEmpty()) {
                    int number = Integer.parseInt(numberInput);
                    if (number <= 0) {
                        throw new IllegalArgumentException("인원수는 1명 이상이어야 합니다.");
                    }
                    return number;
                }
                throw new IllegalArgumentException("인원수는 숫자로 입력해야 합니다.");
            } catch (NumberFormatException e) {
                System.out.println("[오류] 인원수는 숫자로 입력해야 합니다.");
            } catch (IllegalArgumentException e) {
                System.out.println("[오류] " + e.getMessage());
            }
        }
    }



	public static void reservationCancel() {
		
		Scanner scan = new Scanner(System.in);
		
		try {
	        System.out.print("번호: ");
	        int seq = scan.nextInt();

	        Reservation target = null;
	        for (Reservation rv : rlist) {
	            if (rv.getNo() == seq) {
	                target = rv;
	                break;
	            }
	        }

	        if (target == null) {
	            throw new IllegalArgumentException("해당 번호의 예약을 찾을 수 없습니다.");
	        }

	        rlist.remove(target);
	        System.out.println("예약이 취소되었습니다.");
	        
		} catch (IllegalArgumentException e) {
	        System.out.println("[오류] " + e.getMessage());
	        
	    } catch (Exception e) {
	        System.out.println("[오류] 알 수 없는 문제가 발생했습니다. 다시 시도해주세요.");
	    }
		
		save();
		
	}
	
	public static void load() {
		
		try {
			
			BufferedReader reader = new BufferedReader(new FileReader(PATH));
					
            String line = null;
            while ((line = reader.readLine()) != null) {
            	
                String[] parts = line.split(",");
                int no = Integer.parseInt(parts[0]);
                String name = parts[1];
                String phoneNumber = parts[2];
                String dateTime = parts[4];
                int number = Integer.parseInt(parts[3]);
                rlist.add(new Reservation(no, name, phoneNumber, dateTime, number));
            }
            
            reader.close();
            
        } catch (FileNotFoundException e) {
            System.out.println("초기화 파일이 없습니다. 새로 생성합니다.");
        } catch (Exception e) {
            System.out.println("파일 읽기 중 오류 발생: " + e.getMessage());
        }
        
    }
	
	public static void save() {
		
        try {
        	
        	BufferedWriter writer = new BufferedWriter(new FileWriter(PATH));
        	
        	for (Reservation reservation : rlist) {
    			
    			writer.write(String.format("%d,%s,%s,%d,%s\r\n"
    					, reservation.getNo()
    					, reservation.getName()
    					, reservation.getPhoneNumber()
    					, reservation.getNumber()
    					, reservation.getDateTime()));
    		}
    		writer.close();
            
        } catch (Exception e) {
            System.out.println("파일 저장 중 오류 발생: " + e.getMessage());
        }
    }
	
}

		
    
        
    
