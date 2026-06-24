<template>
  <div class="my-work-content">
    <div class="card-grid">
      <div class="project-card border-highlight">
        <div class="card-header">
          <span class="d-day red">0000 / 00 / 00 ( D-14 )</span>
          <span class="status-badge purple">테스트</span>
        </div>
        <h3 class="card-title">주문취소 시 쿠폰 할인취소 정보 ...</h3>
        <div class="progress-section">
          <span class="progress-label">Progress</span>
          <div class="progress-container">
            <div class="progress-bar" style="width: 80%;"></div>
          </div>
          <span class="progress-percentage">80%</span>
          <div class="pointer-hint">👆</div>
        </div>
        <div class="card-footer">
          <span class="meta-item">👤 6</span>
          <span class="meta-item">📋 9</span>
          <span class="meta-item done">✔️ 8 <small>DONE</small></span>
        </div>
      </div>

      <div class="project-card">
        <div class="card-header">
          <span class="d-day red">0000 / 00 / 00 ( D-24 )</span>
          <span class="status-badge gray">협의중</span>
        </div>
        <h3 class="card-title">DL이앤씨 바우처 정책 변경_숙박...</h3>
        <div class="progress-section">
          <span class="progress-label">Progress</span>
          <div class="progress-container">
            <div class="progress-bar" style="width: 30%;"></div>
          </div>
          <span class="progress-percentage">30%</span>
        </div>
        <div class="card-footer">
          <span class="meta-item">👤 4</span>
          <span class="meta-item">📋 5</span>
          <span class="meta-item done">✔️ 3 <small>DONE</small></span>
        </div>
      </div>

      <div class="project-card">
        <div class="card-header">
          <span class="d-day red">0000 / 00 / 00 ( D-37 )</span>
          <span class="status-badge green">처리중</span>
        </div>
        <h3 class="card-title">프로모션 운영 프로세스 및 기능 ..</h3>
        <div class="progress-section">
          <span class="progress-label">Progress</span>
          <div class="progress-container">
            <div class="progress-bar" style="width: 55%;"></div>
          </div>
          <span class="progress-percentage">55%</span>
        </div>
        <div class="card-footer">
          <span class="meta-item">👤 2</span>
          <span class="meta-item">📋 3</span>
          <span class="meta-item done">✔️ 0 <small>DONE</small></span>
        </div>
      </div>

      <div class="project-card card-more">
        <button class="btn-more">···</button>
      </div>
    </div>

    <div class="todo-section">
      <h3 class="section-title">내 할 일 <span class="count">(4)</span></h3>
      
      <div class="todo-table">
        <div class="table-thead">
          <div class="th col-task">업무명</div>
          <div class="th col-due">마감일 (D-day)</div>
          <div class="th col-rate">공정률</div>
          <div class="th col-project">프로젝트명</div>
          <div class="th col-action"></div>
        </div>

        <div class="table-tbody">
          <div class="tr row-alert">
            <div class="td col-task">
              <span>단위 테스트</span>
              <span class="badge-delay">지연</span>
            </div>
            <div class="td col-due red-text">3/20 마감 (D+2)</div>
            <div class="td col-rate">73%</div>
            <div class="td col-project text-ellipsis">프로모션 운영 프로세스 및 기능 개 ...</div>
            <div class="td col-action"><button class="btn-menu">⋮</button></div>
          </div>

          <div class="tr">
            <div class="td col-task">바우처 특복 배정 개발</div>
            <div class="td col-due red-text">3/22 마감 (D-5)</div>
            <div class="td col-rate">45%</div>
            <div class="td col-project text-ellipsis">DL이앤씨 바우처 정책 변경 개발</div>
            <div class="td col-action"><button class="btn-menu">⋮</button></div>
          </div>

          <div class="tr">
            <div class="td col-task">바우처 특복 회수 개발</div>
            <div class="td col-due teal-text">3/30 마감 (D-13)</div>
            <div class="td col-rate">50%</div>
            <div class="td col-project text-ellipsis">DL이앤씨 바우처 정책 변경 개발</div>
            <div class="td col-action"><button class="btn-menu">⋮</button></div>
          </div>

          <div class="tr">
            <div class="td col-task">DEV 테스트</div>
            <div class="td col-due gray-text">일정 미등록</div>
            <div class="td col-rate gray-text">-%</div>
            <div class="td col-project text-ellipsis">주문취소 시 쿠폰 할인취소 정보 노 ...</div>
            <div class="td col-action"><button class="btn-menu">⋮</button></div>
          </div>
        </div>
      </div>
    </div>

    <div class="waiting-section">
      <div class="waiting-header">
        <div class="waiting-title-group">
          <h3 class="section-title">대기 <span class="count">(2)</span></h3>
          <div class="small-arrow-group">
            <button class="btn-small-arrow">◀</button>
            <button class="btn-small-arrow">▶</button>
          </div>
        </div>
      </div>

      <div class="waiting-card-list">
        <div class="waiting-card">
          <div class="w-card-top">
            <span class="status-tag">접수</span>
          </div>
          <h4 class="w-card-title">전사 프로젝트 관리 시스템 구축</h4>
          <div class="w-card-meta">
            <span class="dept">테크담당</span>
            <span class="divider">|</span>
            <span class="d-day red-text">0000 / 00 / 00 ( D-00 )</span>
          </div>
        </div>

        <div class="waiting-card">
          <div class="w-card-top">
            <span class="status-tag">접수</span>
          </div>
          <h4 class="w-card-title">농협카드 인앱 쇼핑몰</h4>
          <div class="w-card-meta">
            <span class="dept">상품사업부</span>
            <span class="divider">|</span>
            <span class="due-info gray-text">오픈일 미정</span>
          </div>
        </div>
      </div>

      <div class="notice-container">
        <h5 class="notice-heading">안내</h5>
        <ul class="notice-list">
          <li>프로젝트 관리 &gt; 요구사항 관리에서 요구사항이 '확정'되면 WBS 관리 메뉴에 작업범위가 자동 생성됩니다.</li>
          <li>WBS 관리 메뉴에서 일정이 등록된 업무만 내 할 일 업무에 일정이 표시됩니다. (단, 캘린더 : 일정 등록된 업무만 표시)</li>
        </ul>
      </div>
    </div>

  </div>
</template>

<script>
export default {
  name: 'MyWorkContentExtended',
  data() {
    return {};
  }
};
</script>

<style scoped>
.my-work-content {
  font-family: 'Malgun Gothic', 'Noto Sans KR', sans-serif;
  padding: 10px 20px 20px 20px;
  background-color: #fafbfc;
  box-sizing: border-box;
  width: 100%;
}

/* --- 1. 프로젝트 카드 스타일 --- */
.card-grid {
  display: block;
  width: 100%;
  margin-bottom: 30px;
}

.project-card {
  display: inline-block;
  vertical-align: top;
  width: 31%;
  margin-right: 2%;
  background-color: #ffffff;
  border: 1px solid #e2e8f0;
  border-radius: 16px;
  padding: 18px;
  box-shadow: 0 4px 10px rgba(0, 0, 0, 0.04);
  box-sizing: border-box;
  position: relative;
}

.project-card.border-highlight {
  box-shadow: 0 0 0 2px #03a65a, 0 4px 12px rgba(3, 166, 90, 0.15);
}

.project-card:nth-child(3) {
  margin-right: 0;
}

.project-card.card-more {
  width: 4%;
  margin-right: 0;
  border: none;
  background: none;
  box-shadow: none;
  text-align: center;
  padding: 50px 0 0 0;
}

.btn-more {
  font-size: 24px;
  color: #aaa;
  cursor: pointer;
  background: none;
  border: none;
}

.card-header {
  margin-bottom: 12px;
}

.card-header .d-day {
  font-size: 13px;
  font-weight: bold;
}
.card-header .d-day.red { color: #dc2626; }

.status-badge {
  float: right;
  font-size: 11px;
  padding: 2px 8px;
  border-radius: 12px;
  font-weight: 500;
  border: 1px solid transparent;
}
.status-badge.purple { background-color: #f3e8ff; color: #7c3aed; }
.status-badge.gray { background-color: #f1f5f9; color: #475569; border-color: #cbd5e1; }
.status-badge.green { background-color: #e2f5ec; color: #03a65a; border-color: #a7f3d0; }

.card-title {
  margin: 0 0 16px 0;
  font-size: 15px;
  font-weight: bold;
  color: #1e293b;
  line-height: 1.4;
  white-space: nowrap;
  overflow: hidden;
  text-overflow: ellipsis;
}

.progress-section {
  position: relative;
  margin-bottom: 16px;
}

.progress-label {
  font-size: 12px;
  color: #64748b;
  display: inline-block;
  margin-bottom: 6px;
}

.progress-container {
  background-color: #f1f5f9;
  border-radius: 6px;
  height: 8px;
  width: 75%;
  display: inline-block;
  vertical-align: middle;
  margin-right: 8px;
  overflow: hidden;
}

.progress-bar {
  background-color: #03a65a;
  height: 100%;
  border-radius: 6px;
}

.progress-percentage {
  font-size: 13px;
  font-weight: bold;
  color: #03a65a;
  display: inline-block;
  vertical-align: middle;
}

.pointer-hint {
  position: absolute;
  right: 25%;
  top: -12px;
  font-size: 20px;
}

.card-footer {
  border-top: 1px solid #f1f5f9;
  padding-top: 12px;
  text-align: right;
}

.meta-item {
  font-size: 12px;
  color: #94a3b8;
  margin-left: 12px;
  display: inline-block;
}
.meta-item.done {
  color: #64748b;
  font-weight: 500;
}
.meta-item.done small {
  font-size: 9px;
  color: #fff;
  background-color: #94a3b8;
  padding: 1px 3px;
  border-radius: 3px;
  vertical-align: middle;
}

/* --- 2. 내 할 일 테이블 스타일 --- */
.todo-section {
  background-color: #ffffff;
  border-radius: 8px;
  padding: 4px 0;
  margin-bottom: 30px;
}

.section-title {
  font-size: 14px;
  font-weight: bold;
  color: #1e293b;
  margin: 0;
  display: inline-block;
  vertical-align: middle;
}
.section-title .count {
  color: #64748b;
  font-weight: normal;
}

.todo-table {
  width: 100%;
  border: 1px solid #e2e8f0;
  border-radius: 6px;
  background-color: #fff;
  margin-top: 12px;
}

.table-thead {
  background-color: #f8fafc;
  border-bottom: 1px solid #e2e8f0;
  padding: 10px 0;
}

.table-thead, .tr {
  display: table;
  width: 100%;
  table-layout: fixed;
  box-sizing: border-box;
}

.th, .td {
  display: table-cell;
  vertical-align: middle;
  padding: 12px 16px;
  font-size: 13px;
  color: #334155;
}

.th {
  font-weight: bold;
  color: #475569;
  padding: 8px 16px;
}

.col-task { width: 25%; text-align: left; }
.col-due { width: 20%; text-align: center; }
.col-rate { width: 12%; text-align: center; }
.col-project { width: 38%; text-align: left; }
.col-action { width: 5%; text-align: center; }

.table-tbody .tr {
  border-bottom: 1px solid #f1f5f9;
}
.table-tbody .tr:last-child {
  border-bottom: none;
}

.tr.row-alert {
  background-color: #fffafb;
  border: 1px solid #fee2e2;
  box-shadow: inset 0 0 0 1px #fca5a5;
}

.badge-delay {
  background-color: #ef4444;
  color: #ffffff;
  font-size: 11px;
  padding: 1px 6px;
  border-radius: 10px;
  margin-left: 6px;
  font-weight: 500;
  vertical-align: middle;
}

.red-text { color: #dc2626; font-weight: 500; }
.teal-text { color: #0ea5e9; }
.gray-text { color: #94a3b8; }

.text-ellipsis {
  white-space: nowrap;
  overflow: hidden;
  text-overflow: ellipsis;
}

.btn-menu {
  background: none;
  border: none;
  color: #64748b;
  font-size: 16px;
  cursor: pointer;
}

/* --- [신규] 3. 대기 프로젝트 및 하단 안내 영역 스타일 --- */
.waiting-section {
  background-color: #ffffff;
  border-radius: 8px;
  padding-top: 10px;
}

.waiting-header {
  margin-bottom: 16px;
}

.waiting-title-group {
  display: flex;
  align-items: center;
  gap: 8px;
}

.small-arrow-group {
  display: inline-flex;
  border: 1px solid #dcdcdc;
  border-radius: 3px;
  vertical-align: middle;
}

.btn-small-arrow {
  padding: 2px 6px;
  font-size: 9px;
  color: #777;
  background-color: #fff;
  border: none;
  cursor: pointer;
}
.btn-small-arrow:first-child {
  border-right: 1px solid #dcdcdc;
}

/* 대기 카드 그리드/가로 배치 */
.waiting-card-list {
  display: block;
  width: 100%;
  margin-bottom: 25px;
}

.waiting-card {
  display: inline-block;
  vertical-align: top;
  width: 23%;
  margin-right: 2%;
  background-color: #ffffff;
  border: 1px solid #e2e8f0;
  border-radius: 12px;
  padding: 16px;
  box-shadow: 0 4px 8px rgba(0, 0, 0, 0.03);
  box-sizing: border-box;
  position: relative;
}

.w-card-top {
  text-align: right;
  margin-bottom: 8px;
  height: 20px;
}

/* 세로형으로 배치된 도장 느낌의 접수 태그 스타일 */
.status-tag {
  display: inline-block;
  border: 1px solid #cbd5e1;
  color: #64748b;
  font-size: 11px;
  padding: 4px 2px;
  line-height: 1.1;
  border-radius: 4px;
  font-weight: bold;
  letter-spacing: 1px;
  background-color: #f8fafc;
  text-align: center;
}

.w-card-title {
  margin: 0 0 12px 0;
  font-size: 14px;
  font-weight: bold;
  color: #1e293b;
  line-height: 1.4;
}

.w-card-meta {
  font-size: 12px;
  color: #64748b;
}

.w-card-meta .divider {
  margin: 0 6px;
  color: #cbd5e1;
}

/* 하단 안내 가이드 박스 */
.notice-container {
  background-color: #f8fafc;
  border: 1px solid #e2e8f0;
  border-radius: 6px;
  padding: 16px 20px;
  margin-top: 20px;
}

.notice-heading {
  margin: 0 0 8px 0;
  font-size: 13px;
  font-weight: bold;
  color: #334155;
}

.notice-list {
  margin: 0;
  padding-left: 14px;
}

.notice-list li {
  font-size: 12px;
  color: #475569;
  line-height: 1.7;
  margin-bottom: 4px;
}
.notice-list li:last-child {
  margin-bottom: 0;
}
</style>