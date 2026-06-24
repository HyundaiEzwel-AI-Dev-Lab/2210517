<template>
  <div class="calendar-view-container">
    <div class="calendar-main-layout">
      
      <div class="calendar-section">
        <div class="calendar-controls">
          <button class="btn-today">오늘</button>
          <div class="month-selector">
            <button class="btn-month-arrow">◀</button>
            <span class="current-month">2026년 3월</span>
            <button class="btn-month-arrow">▶</button>
          </div>
        </div>

        <div class="calendar-grid">
          <div class="calendar-thead">
            <div class="th sun">일</div>
            <div class="th">월</div>
            <div class="th">화</div>
            <div class="th">수</div>
            <div class="th">목</div>
            <div class="th">금</div>
            <div class="th sat">토</div>
          </div>

          <div class="calendar-tbody">
            <div class="calendar-tr">
              <div class="td other-month"><span class="day-num">26</span></div>
              <div class="td other-month"><span class="day-num">27</span></div>
              <div class="td other-month"><span class="day-num">28</span></div>
              <div class="td other-month"><span class="day-num">29</span></div>
              <div class="td other-month"><span class="day-num">30</span></div>
              <div class="td"><span class="day-num">1</span></div>
              <div class="td sat"><span class="day-num">2</span></div>
            </div>

            <div class="calendar-tr">
              <div class="td sun"><span class="day-num">3</span></div>
              <div class="td">
                <span class="day-num">4</span>
                <div class="schedule-bar gray-bar">프로모션 등록 개발 (~ 3/6)</div>
                <div class="schedule-bar gray-bar">프로모션 운영 프로세스 및 기능 개발 (3/20)</div>
              </div>
              <div class="td"><span class="day-num">5</span></div>
              <div class="td"><span class="day-num">6</span></div>
              <div class="td"><span class="day-num">7</span></div>
              <div class="td"><span class="day-num">8</span></div>
              <div class="td sat"><span class="day-num">9</span></div>
            </div>

            <div class="calendar-tr">
              <div class="td sun"><span class="day-num">10</span></div>
              <div class="td"><span class="day-num">11</span></div>
              <div class="td"><span class="day-num">12</span></div>
              <div class="td">
                <span class="day-num">13</span>
                <div class="schedule-bar teal-bar span-3">
                  프로모션 등록 개발 (~ 3/15)
                  <span class="badge-delay">지연</span>
                </div>
                <div class="schedule-bar gray-bar span-3">프로모션 운영 프로세스 및 기능 개발 (3/20)</div>
              </div>
              <div class="td"><span class="day-num">14</span></div>
              <div class="td"><span class="day-num">15</span></div>
              <div class="td sat"><span class="day-num">16</span></div>
            </div>

            <div class="calendar-tr">
              <div class="td sun"><span class="day-num">17</span></div>
              <div class="td current-day">
                <span class="day-num-circle">18</span>
                <div class="schedule-bar red-bar">단위테스트 (~ 3/20)</div>
                <div class="schedule-bar gray-bar">프로모션 운영 프로세스 및 기능 개발 (4/2)</div>
                <div class="schedule-bar orange-bar">바우처 특복 배정 (~ 3/21)</div>
                <button class="btn-more-schedule">+2 더보기</button>
              </div>
              <div class="td">
                <span class="day-num">19</span>
                <button class="btn-more-schedule">+2 더보기</button>
              </div>
              <div class="td">
                <span class="day-num">20</span>
                <button class="btn-more-schedule">+3 더보기</button>
              </div>
              <div class="td">
                <span class="day-num">21</span>
                <div class="schedule-bar red-bar span-3">DEV테스트 (~ 3/20)</div>
                <div class="schedule-bar gray-bar span-3">프로모션 운영 프로세스 및 .. (4/2)</div>
                <button class="btn-more-schedule">+3 더보기</button>
              </div>
              <div class="td"><span class="day-num">22</span><button class="btn-more-schedule">+3 더보기</button></div>
              <div class="td sat"><span class="day-num">23</span></div>
            </div>

            <div class="calendar-tr">
              <div class="td sun"><span class="day-num">24</span></div>
              <div class="td">
                <span class="day-num">25</span>
                <div class="schedule-bar red-bar span-4">바우처 특복 회수 (~ 3/29)</div>
                <div class="schedule-bar teal-bar span-4">DL이앤씨 바우처 정책 변경_숙박바우처 (4/5)</div>
              </div>
              <div class="td"><span class="day-num">26</span></div>
              <div class="td"><span class="day-num">27</span></div>
              <div class="td"><span class="day-num">28</span></div>
              <div class="td"><span class="day-num">29</span></div>
              <div class="td sat"><span class="day-num">30</span></div>
            </div>

            <div class="calendar-tr">
              <div class="td sun"><span class="day-num">31</span></div>
              <div class="td other-month">
                <span class="day-num">1</span>
                <div class="schedule-bar lightgreen-bar">HIMS 개발 (~ 4/3)</div>
                <div class="schedule-bar gray-bar">프로모션 운영 프로세스 및 기능 개발</div>
              </div>
              <div class="td other-month"><span class="day-num">2</span></div>
              <div class="td other-month"><span class="day-num">3</span></div>
              <div class="td other-month"><span class="day-num">4</span></div>
              <div class="td other-month"><span class="day-num">5</span></div>
              <div class="td other-month sat"><span class="day-num">6</span></div>
            </div>
          </div>
        </div>
      </div>

      <div class="sidebar-section">
        <div class="sidebar-header">
          <span class="folder-icon">📁</span>
          <h4 class="sidebar-title">일정 미등록 업무 <span class="count">(0)</span></h4>
        </div>
        <div class="sidebar-body empty-state">
          <div class="empty-message">
            <span class="warning-icon">📝</span>
            <p>일정 미등록 업무가 없습니다.</p>
          </div>
        </div>
      </div>

    </div>
  </div>
</template>

<script>
export default {
  name: 'MyWorkCalendarView',
  data() {
    return {};
  }
};
</script>

<style scoped>
.calendar-view-container {
  font-family: 'Malgun Gothic', 'Noto Sans KR', sans-serif;
  padding: 10px 20px 20px 20px;
  background-color: #ffffff;
  box-sizing: border-box;
  width: 100%;
}

/* 왼쪽 달력 + 오른쪽 사이드바 정렬 */
.calendar-main-layout {
  display: flex;
  gap: 20px;
  width: 100%;
}

.calendar-section {
  flex: 3;
  min-width: 0;
}

.sidebar-section {
  flex: 1;
  max-width: 320px;
  background-color: #ffffff;
  border: 1px solid #e2e8f0;
  border-radius: 12px;
  display: flex;
  flex-direction: column;
}

/* --- 달력 제어부 스타일 --- */
.calendar-controls {
  display: flex;
  align-items: center;
  gap: 15px;
  margin-bottom: 15px;
}

.btn-today {
  border: 1px solid #ced4da;
  border-radius: 4px;
  padding: 4px 12px;
  font-size: 13px;
  background-color: #ffffff;
  color: #333;
  cursor: pointer;
}

.month-selector {
  display: flex;
  align-items: center;
  gap: 10px;
}

.btn-month-arrow {
  background: none;
  border: none;
  font-size: 11px;
  color: #666;
  cursor: pointer;
}

.current-month {
  font-size: 16px;
  font-weight: bold;
  color: #111;
}

/* --- 달력 그리드 테이블 스타일 --- */
.calendar-grid {
  width: 100%;
  border: 1px solid #e2e8f0;
  border-radius: 8px;
  overflow: hidden;
}

.calendar-thead {
  display: flex;
  background-color: #f8fafc;
  border-bottom: 1px solid #e2e8f0;
}

.calendar-thead .th {
  flex: 1;
  padding: 8px;
  text-align: center;
  font-size: 12px;
  font-weight: bold;
  color: #475569;
}
.calendar-thead .th.sun { color: #dc2626; }
.calendar-thead .th.sat { color: #2563eb; }

.calendar-tbody {
  display: flex;
  flex-direction: column;
}

.calendar-tr {
  display: flex;
  border-bottom: 1px solid #f1f5f9;
  min-height: 100px; /* 각 주차별 고정/최소 높이 */
}
.calendar-tr:last-child {
  border-bottom: none;
}

.calendar-tr .td {
  flex: 1;
  padding: 6px 4px;
  border-right: 1px solid #f1f5f9;
  position: relative;
  box-sizing: border-box;
}
.calendar-tr .td:last-child {
  border-right: none;
}

/* 날짜 숫자 스타일 */
.day-num {
  font-size: 12px;
  color: #475569;
  margin-left: 4px;
  display: block;
}
.td.sun .day-num { color: #dc2626; }
.td.sat .day-num { color: #2563eb; }
.td.other-month .day-num { color: #cbd5e1; }

/* 오늘 날짜 하이라이트 동그라미(18일 예시) */
.current-day .day-num-circle {
  display: inline-block;
  background-color: #fee2e2;
  color: #dc2626;
  font-size: 12px;
  font-weight: bold;
  border-radius: 50%;
  width: 22px;
  height: 22px;
  line-height: 22px;
  text-align: center;
  margin-left: 4px;
}

/* --- 일정 스케줄 바(Bar) 스타일 --- */
.schedule-bar {
  font-size: 11px;
  padding: 3px 6px;
  margin-top: 4px;
  border-radius: 3px;
  white-space: nowrap;
  overflow: hidden;
  text-overflow: ellipsis;
  position: relative;
  z-index: 1;
}

/* 여러 칸을 차지하는 일정바 너비 강제 확장(가상 구현 처리) */
.span-3 { width: 295%; z-index: 2; }
.span-4 { width: 395%; z-index: 2; }

/* 이미지 속 컬러 매칭 정의 */
.gray-bar { background-color: #f1f5f9; color: #64748b; }
.teal-bar { background-color: #e0f2fe; color: #0369a1; }
.red-bar { background-color: #ffe4e6; color: #b91c1c; }
.orange-bar { background-color: #ffedd5; color: #c2410c; }
.lightgreen-bar { background-color: #ecfdf5; color: #047857; }

/* 지연 미니 배지 */
.badge-delay {
  background-color: #ef4444;
  color: #fff;
  font-size: 9px;
  padding: 1px 4px;
  border-radius: 8px;
  font-weight: bold;
  float: right;
}

/* +더보기 버튼 */
.btn-more-schedule {
  display: block;
  width: 100%;
  text-align: left;
  background: none;
  border: none;
  color: #94a3b8;
  font-size: 10px;
  margin-top: 3px;
  padding-left: 4px;
  cursor: pointer;
}

/* --- 우측 사이드바 스타일 --- */
.sidebar-header {
  display: flex;
  align-items: center;
  gap: 8px;
  padding: 14px 16px;
  border-bottom: 1px solid #e2e8f0;
}

.folder-icon {
  font-size: 16px;
  color: #64748b;
}

.sidebar-title {
  margin: 0;
  font-size: 14px;
  font-weight: bold;
  color: #1e293b;
}
.sidebar-title .count {
  color: #64748b;
  font-weight: normal;
}

.sidebar-body.empty-state {
  flex: 1;
  display: flex;
  align-items: center;
  justify-content: center;
  padding: 40px 20px;
  text-align: center;
}

.empty-message .warning-icon {
  font-size: 28px;
  color: #cbd5e1;
  display: block;
  margin-bottom: 10px;
}

.empty-message p {
  margin: 0;
  font-size: 13px;
  color: #94a3b8;
}
</style>