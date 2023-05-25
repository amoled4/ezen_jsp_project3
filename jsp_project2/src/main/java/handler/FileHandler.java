package handler;

import java.io.File;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FileHandler {
	private static Logger log = LoggerFactory.getLogger(FileHandler.class);
	
	// 파일이름과 경로를 받아서 파일을 삭제하는 메서드
	// 리턴타입 int => 잘 삭제되었는지 체크하기 위한 변수 (==isOk)
	public int deleteFile(String imageFileName, String savePath) {
		// boolean인 이유는 파일을 삭제하는 메서드의 리턴 타입이 boolean임
		Boolean isDel = false;
		log.info(">>> deleteFile method 접근");
		log.info(">>> imageFileName > "+imageFileName);
		
		File fileDir = new File(savePath);
		File removeFile = new File(fileDir+File.separator+imageFileName);
		File removeThumbFile = new File(fileDir+File.separator+"th_"+imageFileName);
		
		// 파일이 있는지(존재하는지) 확인해야 삭제 가능
		if(removeFile.exists() || removeThumbFile.exists()) {
			isDel = removeFile.delete();  // 리턴 형태는 boolean
			log.info(">>> 파일삭제 > "+(isDel ? "성공": "실패"));
			if(isDel) {   // 메인 파일이 지워졌다면 섬네일 파일도 삭제
				isDel = removeThumbFile.delete();
				log.info(">>> 섬네일삭제 > "+(isDel ? "성공": "실패"));
			}
		}
		log.info(">>> FileHandler remove Ok");
		return isDel? 1: 0;
	}
}
