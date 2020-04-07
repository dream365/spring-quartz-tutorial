Spring Quartz Tutorial
=====
> Spring framework에서 quartz scheduler를 사용하고 공부하기 위해 만든 project입니다.

## Quartz Component

- Job
    - 실제 job을 실행 시키는 클래스로써 job detail에 해당 job type을 알려주어 실행한다.(실질적 구현체)
    - 구현은 Job class를 상속받아 execute함수를 오버라이딩하여 사용    
    
- Job Detail
    - Job을 직접 scheduler에 전달하는것이 아닌 job detail을 사용하여 scheduler가 job을 실행시킨다.    
    
- Trigger
    - Job이 실제 실행시키기 위한 task의 개념이라면 trigger는 스케쥴러가 작동하는 메카니즘에 대한 설명
    - 본 예제 프로젝트에서는 Cron trigger(cron expression 사용하여 작동)과 simple trigger(단순히 ms값 설정하여 작동) 2가지로 나누어 구현    
    
- Scheduler
    - Job scheduler 
    