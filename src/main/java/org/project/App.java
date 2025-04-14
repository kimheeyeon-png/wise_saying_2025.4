package org.project;

import org.system.controller.SystemController;
import org.wiseSaying.controller.WiseSayingController;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class App {

    App() {
    }

    public void run() {
        SystemController systemController = new SystemController();
        WiseSayingController wiseSayingController = new WiseSayingController();

        System.out.println("== motivation 앱 실행 == ");
        byte system_status = 1;
        while (system_status == 1) {
            System.out.print("명령어) ");
            String cmd = Container.getScanner().nextLine().trim();
            Rq rq = new Rq(cmd);
            System.out.println(rq.getActionCode());

            switch (rq.getActionCode()){

                case "delete" :
                    wiseSayingController.remove();
                    break;
                case "add" :
                    wiseSayingController.add();
                case "list" :
                    wiseSayingController.list();
                case "exit" :
                    systemController.exit();
                    system_status = 0;
                    break;
            }

//            if (rq.getActionCode().equals("delete")) {
//                wiseSayingController.remove();
//            } else if (rq.getActionCode().equals("add")) {
//                wiseSayingController.add();
//            } else if (rq.getActionCode().equals("list")) {
//                wiseSayingController.list();
//            } else if (rq.getActionCode().equals("exit")) {
//                systemController.exit();
//                break;
//            } else {
//                System.out.println("존재하지 않는 명령어입니다.");
//            }
        }
    }
}