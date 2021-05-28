package net.lnworks.monitor.role;

import java.util.List;

public class AERoleLogic {

    /**
     * 최상위값
     * */
    public String aeGrade(List<String> getNumList) {
        int getnNum = 0;
        String returnVal = "";

        for (String numVal : getNumList) {
            if ( numVal != null ) {
                int num = Integer.parseInt(numVal);
                if (getnNum < num) {
                    getnNum = num;
                }
            }
        }
        returnVal = returnVal + (getnNum/10);
        return returnVal;
    }

    /**
     * AE숫자는 두자리 수로
     * */
    public String aeNum(String getNum) {
        String retunVal = "0";
        if ( getNum != null ) {
            if (getNum.length() < 2) {
                retunVal = retunVal + getNum;
            } else {
                retunVal = getNum;
            }
        }
        return  retunVal;
    }

    /**
     * 목록중에 Y값이 있으면 Y로 처리
     * */
    public String aeTopYes(List<String> getList) {
        String retunVal = "No";

        for (String str : getList) {
            if ( str != null && str.equals("Y")) {
                retunVal = "Yes";
                break;
            }
        }

        return retunVal;
    }

    /**
     * 'Y'값이 있으면 defaultVal값을 전달
     * */
    public String aeYesDefaultValue(List<String> getList, String defaultVal) {
        String retunVal = "";
        for (String str : getList) {
            if ( str != null && str.equals("Y")) {
                retunVal = defaultVal;
                break;
            }
        }
        return retunVal;
    }

    /**
     * 목록중에 값이 있으면 있는 값으로
     * 가장 마지막 값
     * */
    public String aeTopNotEmpty(List<String> getList) {
        String retunVal = "";

        for (String str : getList) {
            if ( str != null && !str.equals("")) {
                retunVal = str;
                break;
            }
        }

        return retunVal;
    }

    /**
     * 관련조치
     * '용량변경 없음'과 "용량감소'가 있다면 '용량감소'로 수집
     * '용량변경 없음'과 "일시중단'이 있다면 '일시중단'으로 수집
     * '용량변경 없음'과 "영구중단'이 있다면 '영구중단'으로 수집
     * '용량변경 없음', '일시중단, '영구중단'이 있다면 '영구중단'으로 수집
     * '용량변경 없음', '용량감소, '영구중단'이 있다면 '영구중단'으로 수집
     * '용량변경 없음', '용량증가, '영구중단'이 있다면 '영구중단'으로 수집
     * '용량변경 없음', '용량증가, '일시중단'이 있다면 '용량증가'로 수집
     * '용량변경 없음', '용량감소, '일시중단'이 있다면 '용량감소'로 수집
     * '상기조건에 해당되지 않으면 'null'값으로 입력
     * */
    public String aeRelationMeasure(List<String> getList) {
        String retunVal = "모름";
        String tempVal = "";

        for (String str : getList) {
            if ( str != null && !str.equals("")) {
                retunVal = str;
                if ( retunVal.equals("영구 중단") ) {
                    break;
                }

                if ( retunVal.equals("용량 감소") ) {
                    tempVal = retunVal;
                }

                if ( retunVal.equals("용량 증가") ) {
                    if (tempVal.equals("용량 감소") ) {
                        retunVal = tempVal;
                    }
                }

                if ( retunVal.equals("일시 중단") ) {
                    if (tempVal.equals("용량 감소") || tempVal.equals("용량 증가")) {
                        retunVal = tempVal;
                    }
                }

                if ( retunVal.equals("용량변경 없음") ) {
                    if (tempVal.equals("용량 감소") || tempVal.equals("용량 증가") || tempVal.equals("일시 중단")) {
                        retunVal = tempVal;
                    }
                }

                if (!tempVal.equals("")) {
                    retunVal = tempVal;
                }
            }
        }

        return retunVal;
    }

    /**
     * 기타조치
     * '약물요법'이나 '시술/처치'가 있다면 없음이 아닌 해당 입력내용으로 수집
     * '약물요법'과 '시술/처치'가 모두 있다면 '약물요법, 시술/처치'로 수집
     * */
    public String aeEtcMeasure(List<String> getList) {
        String retunVal = "없음";
        String tempVal = "";

        for (String str : getList) {
            if ( str != null && !str.equals("")) {
                retunVal = str;
                if ( retunVal.equals("약물요법, 시술/처치") ) {
                    break;
                }

                if ( retunVal.equals("약물요법") || retunVal.equals("시술/처치")) {
                    if ( tempVal.equals("약물요법") || tempVal.equals("시술/처치")) {
                        if ( !retunVal.equals(tempVal)) {
                            retunVal = "약물요법, 시술/처치";
                            break;
                        }
                    }
                    else {
                        tempVal = retunVal;
                    }
                }

                if (!tempVal.equals("")) {
                    retunVal = tempVal;
                }
            }
        }

        return retunVal;
    }

    /**
     * 결과
     * '회복중'과 '회복됨'이 있다면 '회복됨'으로 입력
     * '회복중'과 '회복됨(후유증동반)'이 있다면 '회복됨(후유증동반)'으로 입력
     * '회복중'과 '회복안됨'이 있다면 '회복안됨'으로 입력
     * '회복중', '회복됨', '회복됨(휴유증동반)' 이 있다면 '회복됨(휴유증동반)'으로 입력
     * */
    public String aeResult(List<String> getList) {
        String retunVal = "모름";
        String tempVal = "";

        for (String str : getList) {
            if ( str != null && !str.equals("")) {
                retunVal = str;
                if ( retunVal.equals("회복됨(후유증동반)")) {
                    break;
                }

                if ( retunVal.equals("회복안됨")) {
                    tempVal = retunVal;
                }

                if ( retunVal.equals("회복중") ) {
                    if ( tempVal.equals("회복안됨")) {
                        retunVal = tempVal;
                    }
                    else {
                        tempVal = retunVal;
                    }
                }

                if ( retunVal.equals("회복됨") ) {
                    if ( tempVal.equals("회복안됨") || tempVal.equals("회복중")) {
                        retunVal = tempVal;
                    }
                }

                if (!tempVal.equals("")) {
                    retunVal = tempVal;
                }
            }
        }
        return retunVal;
    }

    public String emptyChk(String checkVal) {
        if ( checkVal == null) {
            return  "";
        }
        else {
            return  checkVal;
        }
    }
}
