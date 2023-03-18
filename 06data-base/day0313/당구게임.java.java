import java.net.*;
import java.io.*;

public class SEOUL08_KIMBOYEON_HONGSUNGMIN {

	// 닉네임을 사용자에 맞게 변경해 주세요.
	static final String NICKNAME = "SEOUL08_KIMBOYEON_HONGSUNGMIN";
	
	// 일타싸피 프로그램을 로컬에서 실행할 경우 변경하지 않습니다.
	static final String HOST = "127.0.0.1";

	// 일타싸피 프로그램과 통신할 때 사용하는 코드값으로 변경하지 않습니다.
	static final int PORT = 1447;
	static final int CODE_SEND = 9901;
	static final int CODE_REQUEST = 9902;
	static final int SIGNAL_ORDER = 9908;
	static final int SIGNAL_CLOSE = 9909;

	// 게임 환경에 대한 상수입니다.
	static final int TABLE_WIDTH = 254;
	static final int TABLE_HEIGHT = 127;
	static final int NUMBER_OF_BALLS = 6;
	static final int[][] HOLES = { { 0, 0 }, { 127, 0 }, { 254, 0 }, { 0, 127 }, { 127, 127 }, { 254, 127 } };

	public static void main(String[] args) {

		Socket socket = null;
		String recv_data = null;
		byte[] bytes = new byte[1024];
		float[][] balls = new float[NUMBER_OF_BALLS][2];
		int order = 0;

		try {
			socket = new Socket();
			System.out.println("Trying Connect: " + HOST + ":" + PORT);
			socket.connect(new InetSocketAddress(HOST, PORT));
			System.out.println("Connected: " + HOST + ":" + PORT);

			InputStream is = socket.getInputStream();
			OutputStream os = socket.getOutputStream();

			String send_data = CODE_SEND + "/" + NICKNAME + "/";
			bytes = send_data.getBytes("UTF-8");
			os.write(bytes);
			os.flush();
			System.out.println("Ready to play!\n--------------------");

			while (socket != null) {

				// Receive Data
				bytes = new byte[1024];
				int count_byte = is.read(bytes);
				recv_data = new String(bytes, 0, count_byte, "UTF-8");
				System.out.println("Data Received: " + recv_data);

				// Read Game Data
				String[] split_data = recv_data.split("/");
				int idx = 0;
				try {
					for (int i = 0; i < NUMBER_OF_BALLS; i++) {
						for (int j = 0; j < 2; j++) {
							balls[i][j] = Float.parseFloat(split_data[idx++]);
						}
					}
				} catch (Exception e) {
					bytes = (CODE_REQUEST + "/" + CODE_REQUEST).getBytes("UTF-8");
					os.write(bytes);
					os.flush();
					System.out.println("Received Data has been currupted, Resend Requested.");
					continue;
				}

				// Check Signal for Player Order or Close Connection
				if (balls[0][0] == SIGNAL_ORDER) {
					order = (int)balls[0][1];
					System.out.println("\n* You will be the " + (order == 1 ? "first" : "second") + " player. *\n");
					continue;
				} else if (balls[0][0] == SIGNAL_CLOSE) {
					break;
				}

				// Show Balls' Position
				for (int i = 0; i < NUMBER_OF_BALLS; i++) {
					System.out.println("Ball " + i + ": " + balls[i][0] + ", " + balls[i][1]);
				}

				float angle = 0.0f;
				float power = 0.0f;

				//////////////////////////////
				// 이 위는 일타싸피와 통신하여 데이터를 주고 받기 위해 작성된 부분이므로 수정하면 안됩니다.
				//
				// 모든 수신값은 변수, 배열에서 확인할 수 있습니다.
				//   - order: 1인 경우 선공, 2인 경우 후공을 의미
				//   - balls[][]: 일타싸피 정보를 수신해서 각 공의 좌표를 배열로 저장
				//     예) balls[0][0]: 흰 공의 X좌표
				//         balls[0][1]: 흰 공의 Y좌표
				//         balls[1][0]: 1번 공의 X좌표
				//         balls[4][0]: 4번 공의 X좌표
				//         balls[5][0]: 마지막 번호(8번) 공의 X좌표
				
				// 여기서부터 코드를 작성하세요.
				// 아래에 있는 것은 샘플로 작성된 코드이므로 자유롭게 변경할 수 있습니다.
				





				// whiteBall_x, whiteBall_y: 흰 공의 X, Y좌표를 나타내기 위해 사용한 변수
				float whiteBall_x = balls[0][0];
				float whiteBall_y = balls[0][1];
				
				float targetBall_x1 = balls[1][0];
				float targetBall_y1 = balls[1][1];
				
				float targetBall_x3 = balls[3][0];
				float targetBall_y3 = balls[3][1];
				
				float targetBall_x2 = balls[2][0];
				float targetBall_y2 = balls[2][1];
				
				float targetBall_x4 = balls[4][0];
				float targetBall_y4 = balls[4][1];
				
				float targetBall_x8 = balls[5][0];
				float targetBall_y8 = balls[5][1];

				// width, height: 목적구와 흰 공의 X좌표 간의 거리, Y좌표 간의 거리
				float width1 = Math.abs(targetBall_x1 - whiteBall_x);
				float height1 = Math.abs(targetBall_y1 - whiteBall_y);

				float width2 = Math.abs(targetBall_x2 - whiteBall_x);
				float height2 = Math.abs(targetBall_y2 - whiteBall_y);
				
				float width3 = Math.abs(targetBall_x3 - whiteBall_x);
				float height3 = Math.abs(targetBall_y3 - whiteBall_y);
				
				float width4 = Math.abs(targetBall_x4 - whiteBall_x);
				float height4 = Math.abs(targetBall_y4 - whiteBall_y);
				
				float width8 = Math.abs(targetBall_x8 - whiteBall_x);
				float height8 = Math.abs(targetBall_y8 - whiteBall_y);

				// radian: width와 height를 두 변으로 하는 직각삼각형의 각도를 구한 결과
				//   - 1radian = 180 / PI (도)
				//   - 1도 = PI / 180 (radian)
				// angle : 아크탄젠트로 얻은 각도 radian을 degree로 환산한 결과
				double radian;

				switch(order) {
					case 1 :
						// 1번 공
						// 목적구가 상하좌우로 일직선상에 위치했을 때 각도 입력
						if(targetBall_x1 != -1.0 && targetBall_y1 != -1.0) {
							
							if (whiteBall_x == targetBall_x1)
							{
								if (whiteBall_y < targetBall_y1)
								{
									angle = 0;
								}
								else
								{
									angle = 180;
								}
							}
							else if (whiteBall_y == targetBall_y1)
							{
								if (whiteBall_x < targetBall_x1)
								{
									angle = 90;
								}
								else
								{
									angle = 270;
								}
							}
							
							// 목적구가 흰 공을 중심으로 3사분면에 위치했을 때 각도를 재계산
							if (whiteBall_x > targetBall_x1 && whiteBall_y > targetBall_y1)
							{
								radian = Math.atan(width1 / height1);
								angle = (float) (((180.0 / Math.PI) * radian) + 180);
							}
							
							// 목적구가 흰 공을 중심으로 4사분면에 위치했을 때 각도를 재계산
							else if (whiteBall_x < targetBall_x1 && whiteBall_y > targetBall_y1)
							{
								radian = Math.atan(height1 / width1);
								angle = (float) (((180.0 / Math.PI) * radian) + 90);
							}
							
							// 목적구가 흰 공을 중심으로 2사분면에 위치했을 때 각도를 재계산
							else if (whiteBall_x > targetBall_x1 && whiteBall_y < targetBall_y1)
							{
								radian = Math.atan(width1 / height1);
								angle = (float) ((360.0 - (180.0 / Math.PI) * radian));
							}
							// 목적구가 흰 공을 중심으로 1사분면에 위치했을 때 각도를 재계산
							else if (whiteBall_x < targetBall_x1 && whiteBall_y < targetBall_y1)
							{
								radian = Math.atan(width1 / height1);
								angle = (float) (((180.0 / Math.PI) * radian));
							}
							
							// distance: 두 점(좌표) 사이의 거리를 계산
							double distance1 = Math.sqrt((width1 * width1) + (height1 * height1));
							
							// power: 거리 distance에 따른 힘의 세기를 계산
							power = (float) distance1;
						}
						
						// 3번 공
						// 목적구가 상하좌우로 일직선상에 위치했을 때 각도 입력
						if(targetBall_x3 != -1.0 && targetBall_y3 != -1.0) {
							
							if (whiteBall_x == targetBall_x3)
							{
								if (whiteBall_y < targetBall_y3)
								{
									angle = 0;
								}
								else
								{
									angle = 180;
								}
							}
							else if (whiteBall_y == targetBall_y3)
							{
								if (whiteBall_x < targetBall_x3)
								{
									angle = 90;
								}
								else
								{
									angle = 270;
								}
							}
							
							// 목적구가 흰 공을 중심으로 3사분면에 위치했을 때 각도를 재계산
							if (whiteBall_x > targetBall_x3 && whiteBall_y > targetBall_y3)
							{
								radian = Math.atan(width3 / height3);
								angle = (float) (((180.0 / Math.PI) * radian) + 180);
							}
							
							// 목적구가 흰 공을 중심으로 4사분면에 위치했을 때 각도를 재계산
							else if (whiteBall_x < targetBall_x3 && whiteBall_y > targetBall_y3)
							{
								radian = Math.atan(height3 / width3);
								angle = (float) (((180.0 / Math.PI) * radian) + 90);
							}
							
							// 목적구가 흰 공을 중심으로 2사분면에 위치했을 때 각도를 재계산
							else if (whiteBall_x > targetBall_x3 && whiteBall_y < targetBall_y3)
							{
								radian = Math.atan(width3 / height3);
								angle = (float) ((360.0 - (180.0 / Math.PI) * radian));
							}
							// 목적구가 흰 공을 중심으로 1사분면에 위치했을 때 각도를 재계산
							else if (whiteBall_x < targetBall_x3 && whiteBall_y < targetBall_y3)
							{
								radian = Math.atan(width3 / height3);
								angle = (float) (((180.0 / Math.PI) * radian));
							}
							
							// distance: 두 점(좌표) 사이의 거리를 계산
							double distance3 = Math.sqrt((width3 * width3) + (height3 * height3));
							
							// power: 거리 distance에 따른 힘의 세기를 계산
							power = (float) distance3;
						}
						
						if(targetBall_x1 == -1.0 && targetBall_x3 == -1.0) {
							if (whiteBall_x == targetBall_x8)
							{
								if (whiteBall_y < targetBall_y8)
								{
									angle = 0;
								}
								else
								{
									angle = 180;
								}
							}
							else if (whiteBall_y == targetBall_y8)
							{
								if (whiteBall_x < targetBall_x8)
								{
									angle = 90;
								}
								else
								{
									angle = 270;
								}
							}
							
							// 목적구가 흰 공을 중심으로 3사분면에 위치했을 때 각도를 재계산
							if (whiteBall_x > targetBall_x8 && whiteBall_y > targetBall_y8)
							{
								radian = Math.atan(width8 / height8);
								angle = (float) (((180.0 / Math.PI) * radian) + 180);
							}
							
							// 목적구가 흰 공을 중심으로 4사분면에 위치했을 때 각도를 재계산
							else if (whiteBall_x < targetBall_x8 && whiteBall_y > targetBall_y8)
							{
								radian = Math.atan(height8 / width8);
								angle = (float) (((180.0 / Math.PI) * radian) + 90);
							}
							
							// 목적구가 흰 공을 중심으로 2사분면에 위치했을 때 각도를 재계산
							else if (whiteBall_x > targetBall_x8 && whiteBall_y < targetBall_y8)
							{
								radian = Math.atan(width8 / height8);
								angle = (float) ((360.0 - (180.0 / Math.PI) * radian));
							}
							// 목적구가 흰 공을 중심으로 1사분면에 위치했을 때 각도를 재계산
							else if (whiteBall_x < targetBall_x8 && whiteBall_y < targetBall_y8)
							{
								radian = Math.atan(width8 / height8);
								angle = (float) (((180.0 / Math.PI) * radian));
							}
							
							// distance: 두 점(좌표) 사이의 거리를 계산
							double distance8 = Math.sqrt((width8 * width8) + (height8 * height8));
							
							// power: 거리 distance에 따른 힘의 세기를 계산
							power = (float) distance8;
						}
						break;
					case 2 :
						
						// 2번 공
						// 목적구가 상하좌우로 일직선상에 위치했을 때 각도 입력
						if(targetBall_x2 != -1.0 && targetBall_y2 != -1.0) {
							
							if (whiteBall_x == targetBall_x2)
							{
								if (whiteBall_y < targetBall_y2)
								{
									angle = 0;
								}
								else
								{
									angle = 180;
								}
							}
							else if (whiteBall_y == targetBall_y2)
							{
								if (whiteBall_x < targetBall_x2)
								{
									angle = 90;
								}
								else
								{
									angle = 270;
								}
							}
							
							// 목적구가 흰 공을 중심으로 3사분면에 위치했을 때 각도를 재계산
							if (whiteBall_x > targetBall_x2 && whiteBall_y > targetBall_y2)
							{
								radian = Math.atan(width2 / height2);
								angle = (float) (((180.0 / Math.PI) * radian) + 180);
							}
							
							// 목적구가 흰 공을 중심으로 4사분면에 위치했을 때 각도를 재계산
							else if (whiteBall_x < targetBall_x2 && whiteBall_y > targetBall_y2)
							{
								radian = Math.atan(height2 / width2);
								angle = (float) (((180.0 / Math.PI) * radian) + 90);
							}
							
							// 목적구가 흰 공을 중심으로 2사분면에 위치했을 때 각도를 재계산
							else if (whiteBall_x > targetBall_x2 && whiteBall_y < targetBall_y2)
							{
								radian = Math.atan(width2 / height2);
								angle = (float) ((360.0 - (180.0 / Math.PI) * radian));
							}
							// 목적구가 흰 공을 중심으로 1사분면에 위치했을 때 각도를 재계산
							else if (whiteBall_x < targetBall_x2 && whiteBall_y < targetBall_y2)
							{
								radian = Math.atan(width2 / height2);
								angle = (float) (((180.0 / Math.PI) * radian));
							}
							
							// distance: 두 점(좌표) 사이의 거리를 계산
							double distance2 = Math.sqrt((width2 * width2) + (height2 * height2));
							
							// power: 거리 distance에 따른 힘의 세기를 계산
							power = (float) distance2;
						}
						
						// 4번 공
						// 목적구가 상하좌우로 일직선상에 위치했을 때 각도 입력
						if(targetBall_x4 != -1.0 && targetBall_y4 != -1.0) {
							
							if (whiteBall_x == targetBall_x4)
							{
								if (whiteBall_y < targetBall_y4)
								{
									angle = 0;
								}
								else
								{
									angle = 180;
								}
							}
							else if (whiteBall_y == targetBall_y4)
							{
								if (whiteBall_x < targetBall_x4)
								{
									angle = 90;
								}
								else
								{
									angle = 270;
								}
							}
							
							// 목적구가 흰 공을 중심으로 3사분면에 위치했을 때 각도를 재계산
							if (whiteBall_x > targetBall_x4 && whiteBall_y > targetBall_y4)
							{
								radian = Math.atan(width4 / height4);
								angle = (float) (((180.0 / Math.PI) * radian) + 180);
							}
							
							// 목적구가 흰 공을 중심으로 4사분면에 위치했을 때 각도를 재계산
							else if (whiteBall_x < targetBall_x4 && whiteBall_y > targetBall_y4)
							{
								radian = Math.atan(height4 / width4);
								angle = (float) (((180.0 / Math.PI) * radian) + 90);
							}
							
							// 목적구가 흰 공을 중심으로 2사분면에 위치했을 때 각도를 재계산
							else if (whiteBall_x > targetBall_x4 && whiteBall_y < targetBall_y4)
							{
								radian = Math.atan(width4 / height4);
								angle = (float) ((360.0 - (180.0 / Math.PI) * radian));
							}
							// 목적구가 흰 공을 중심으로 1사분면에 위치했을 때 각도를 재계산
							else if (whiteBall_x < targetBall_x4 && whiteBall_y < targetBall_y4)
							{
								radian = Math.atan(width4 / height4);
								angle = (float) (((180.0 / Math.PI) * radian));
							}
							
							// distance: 두 점(좌표) 사이의 거리를 계산
							double distance4 = Math.sqrt((width4 * width4) + (height4 * height4));
							
							// power: 거리 distance에 따른 힘의 세기를 계산
							power = (float) distance4;
							
						}
						
						if(targetBall_x2 == -1.0 && targetBall_x4 == -1.0) {
							if (whiteBall_x == targetBall_x8)
							{
								if (whiteBall_y < targetBall_y8)
								{
									angle = 0;
								}
								else
								{
									angle = 180;
								}
							}
							else if (whiteBall_y == targetBall_y8)
							{
								if (whiteBall_x < targetBall_x8)
								{
									angle = 90;
								}
								else
								{
									angle = 270;
								}
							}
							
							// 목적구가 흰 공을 중심으로 3사분면에 위치했을 때 각도를 재계산
							if (whiteBall_x > targetBall_x8 && whiteBall_y > targetBall_y8)
							{
								radian = Math.atan(width8 / height8);
								angle = (float) (((180.0 / Math.PI) * radian) + 180);
							}
							
							// 목적구가 흰 공을 중심으로 4사분면에 위치했을 때 각도를 재계산
							else if (whiteBall_x < targetBall_x8 && whiteBall_y > targetBall_y8)
							{
								radian = Math.atan(height8 / width8);
								angle = (float) (((180.0 / Math.PI) * radian) + 90);
							}
							
							// 목적구가 흰 공을 중심으로 2사분면에 위치했을 때 각도를 재계산
							else if (whiteBall_x > targetBall_x8 && whiteBall_y < targetBall_y8)
							{
								radian = Math.atan(width8 / height8);
								angle = (float) ((360.0 - (180.0 / Math.PI) * radian));
							}
							// 목적구가 흰 공을 중심으로 1사분면에 위치했을 때 각도를 재계산
							else if (whiteBall_x < targetBall_x8 && whiteBall_y < targetBall_y8)
							{
								radian = Math.atan(width8 / height8);
								angle = (float) (((180.0 / Math.PI) * radian));
							}
							
							// distance: 두 점(좌표) 사이의 거리를 계산
							double distance8 = Math.sqrt((width8 * width8) + (height8 * height8));
							
							// power: 거리 distance에 따른 힘의 세기를 계산
							power = (float) distance8;
						}
						break;
				}

				// 주어진 데이터(공의 좌표)를 활용하여 두 개의 값을 최종 결정하고 나면,
				// 나머지 코드에서 일타싸피로 값을 보내 자동으로 플레이를 진행하게 합니다.
				//   - angle: 흰 공을 때려서 보낼 방향(각도)
				//   - power: 흰 공을 때릴 힘의 세기
				// 
				// 이 때 주의할 점은 power는 100을 초과할 수 없으며,
				// power = 0인 경우 힘이 제로(0)이므로 아무런 반응이 나타나지 않습니다.
				//
				// 아래는 일타싸피와 통신하는 나머지 부분이므로 수정하면 안됩니다.
				//////////////////////////////

				String merged_data = angle + "/" + power + "/";
				bytes = merged_data.getBytes("UTF-8");
				os.write(bytes);
				os.flush();
				System.out.println("Data Sent: " + merged_data);
			}

			os.close();
			is.close();
			socket.close();
			System.out.println("Connection Closed.\n--------------------");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}