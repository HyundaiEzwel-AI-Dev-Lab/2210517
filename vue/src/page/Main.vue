<template>
  <div class="app-layout">
    <aside class="sidebar">
      <div class="logo-zone">
        <h2>전사 PM 시스템</h2>
      </div>
      
      <nav class="menu-container">
        <!-- v-if="menu"를 추가하여 데이터가 로드된 경우만 렌더링 -->
        <div v-for="(menu, index) in menuList" :key="index" class="menu-group" v-if="menuList.length > 0">
          <div 
            class="main-menu" 
            :class="{ active: menu.active || currentMainMenu === menu.menuName }"
            @click="toggleMenu(menu)"
          >
            <!-- 여기서 menuName을 사용합니다 -->
            <span>{{ menu.menuName }}</span>
            <span v-if="menu.subMenus && menu.subMenus.length > 0" class="arrow-icon">
              {{ menu.expanded ? '▼' : '▶' }}
            </span>
          </div>
          
          <transition name="slide">
            <div v-if="menu.subMenus && menu.subMenus.length > 0 && menu.expanded" class="sub-menu-list">
              <div 
                v-for="(sub, sIndex) in menu.subMenus"
                :key="sIndex"
                class="sub-menu"
                :class="{ active: sub.current }"
                @click="selectSubMenu(sub)"
              >
                <!-- 서브메뉴도 이름 필드가 menuName이라면 아래와 같이 수정 -->
                {{ sub.menuName }}
              </div>
            </div>
          </transition>
        </div>
      </nav>
    </aside>

    <main class="main-content">
<div class="my-work-container">
    <div class="tab-header">
      <div class="tab active">
        <span class="badge-integrated">통합</span>
        <span class="tab-title">내업무</span>
        <button class="btn-close">×</button>
      </div>
      <div class="header-utilities">
        <div class="arrow-group">
          <button class="btn-arrow">◀</button>
          <button class="btn-arrow">▶</button>
        </div>
        <div class="icon-group">
          <button class="btn-icon">🔍</button>
          <button class="btn-icon badge-notification">🔔</button>
          <button class="btn-icon">📁</button>
          <button class="btn-icon profile-avatar">👤</button>
        </div>
      </div>
    </div>

    <div class="title-section">
      <h2>내업무</h2>
      <div class="breadcrumb">
        <span>🏠</span> &gt; <span>내업무</span>
      </div>
    </div>

    <div class="summary-dashboard">
      <div class="summary-card">
        <span class="label">진행 프로젝트</span>
        <span class="count black"><strong>5</strong> 건</span>
      </div>
      <div class="summary-card">
        <span class="label">내 할 일</span>
        <span class="count teal"><strong>4</strong> 건</span>
      </div>
      <div class="summary-card highlight-red">
        <span class="label">금주 마감</span>
        <span class="count red"><strong>2</strong> 건</span>
      </div>
      <div class="summary-card">
        <span class="label">지연</span>
        <span class="count orange"><strong>1</strong> 건</span>
      </div>
      <div class="summary-card">
        <span class="label">대기</span>
        <span class="count black"><strong>2</strong> 건</span>
      </div>
    </div>

    <div class="controller-section">
      <div class="filter-left">
        <span class="filter-title">진행중</span>
        <span class="filter-count">(5)</span>
        <div class="small-arrow-group">
          <button class="btn-small-arrow">◀</button>
          <button class="btn-small-arrow">▶</button>
        </div>
      </div>
      <div class="view-switch-right">
        <button
          class="btn-switch"
          :class="{ active: currentView === 'cal' }"
          @click="currentView = 'cal'"
        >캘린더형</button>
        <button
          class="btn-switch"
          :class="{ active: currentView === 'card' }"
          @click="currentView = 'card'"
        >카드형</button>
      </div>
    </div>
  </div>

  <div id="main_area">
    <!-- currentView 값에 따라 컴포넌트가 교체됨 (겹치지 않음) -->
    <PmsCalender v-if="currentView === 'cal'" />
    <PmsCard v-else-if="currentView === 'card'" />
  </div>
    </main>
  </div>
</template>

<script>
import PmsCard from '../components/PmsCard.vue';
import PmsCalender from '../components/PmsCalender.vue';
import axios from 'axios';

export default {
  name: 'DevTestManagementWithSidebar',
  components: {
    PmsCard,
    PmsCalender
  },
  data() {
    return {
      currentView: 'card',
      currentMainMenu: '프로젝트 관리',
      menuList: [],
      // 테스트 컨텐츠 데이터
      totalProgress: 65,
      currentTab: 2, 
      isAllSelected: false,
      selectedItems: [],
      tabList: [
        { id: 1, name: '1차 테스트' },
        { id: 2, name: '2차 테스트 (DEV)' },
        { id: 3, name: '3차 테스트 (운영)' },
        { id: 4, name: '4차 차수' },
        { id: 5, name: '5차 차수' }
      ],
      scenarios: [
        { id: 1, tabId: 2, path: 'FO > 법인숙박 > 여행레저 > 복지혜택', screenName: '복지혜택 신청', reqId: 'REQ-001', cases: 2, steps: 14, progress: 80, status: '진행중' },
        { id: 2, tabId: 2, path: 'HIMS > 법인숙박 > 주문관리 > 법인콘도', screenName: '법인콘도 신청관리', reqId: 'REQ-002', cases: 1, steps: 6, progress: 100, status: '완료' },
        { id: 3, tabId: 2, path: 'FO > 주문클레임 > 주문 > 결제페이지', screenName: '바우처 특복 배정', reqId: 'REQ-003', cases: 1, steps: 5, progress: 0, status: '대기' }
      ]
    };
  },
  created() {
    this.fetchMenuList();
  },
  computed: {
    currentTabData() {
      return this.scenarios.filter(item => item.tabId === this.currentTab);
    }
  },
  methods: {
    async fetchMenuList() {
      try {
        const response = await axios.get('http://localhost:8081/api/menu');
        this.menuList = response.data;
      } catch (error) {
        console.error('메뉴 데이터를 가져오는 중 오류 발생:', error);
      }
    },
    toggleMenu(menu) {
      if (menu.subMenus) {
        menu.expanded = !menu.expanded;
      } else {
        this.currentMainMenu = menu.menuName;
        alert(`${menu.menuName} 페이지로 이동합니다.`);
      }
    },
    selectSubMenu(sub) {
      this.menuList.forEach(m => {
        if (m.subMenus) m.subMenus.forEach(s => s.current = false);
      });
      sub.current = true;
    },
    selectAll() {
      this.selectedItems = this.isAllSelected ? this.currentTabData.map(item => item.id) : [];
    },
    getProgressColor(progress) {
      if (progress === 100) return '#28a745';
      if (progress > 0) return '#007bff';
      return '#ced4da';
    },
    getStatusColor(status) {
      if (status === '완료') return '#28a745';
      if (status === '진행중') return '#007bff';
      return '#6c757d';
    },
    copyLibrary() { alert('라이브러리 복사 기능을 실행합니다.'); },
    registerNewCase() { alert('신규 시나리오 등록 양식 팝업을 엽니다.'); },
    changeOrder() { alert('순서 변경 모드를 활성화합니다.'); },
    toggleAllRows() { alert('목록 그리드를 확장합니다.'); },
    importTargets() { alert('요구사항 대상 목록을 호출합니다.'); },

    goToPmsCard() {
      this.$router.push('/pms-card');
    },
    goToPmsCalendar() {
      this.$router.router.push('/pms-calendar');
    }
  }
};
</script>

<style scoped>
/* 좌측 메뉴 및 메인 컨텐츠 배치를 위한 Flex 레이아웃 */
.app-layout { display: flex; min-height: 100vh; background-color: #f8f9fa; }

/* 1. 사이드바 스타일 */
.sidebar { width: 240px; background-color: #2c3e50; color: #ecf0f1; display: flex; flex-direction: column; flex-shrink: 0; box-shadow: 2px 0 5px rgba(0,0,0,0.1); }
.logo-zone { padding: 20px; border-bottom: 1px solid #34495e; text-align: center; }
.logo-zone h2 { font-size: 18px; margin: 0; color: #fff; font-weight: 700; }
.menu-container { flex: 1; padding: 15px 0; overflow-y: auto; }
.menu-group { margin-bottom: 5px; }

.main-menu { padding: 12px 20px; font-size: 14px; font-weight: bold; cursor: pointer; display: flex; justify-content: space-between; align-items: center; color: #bdc3c7; transition: background 0.2s, color 0.2s; }
.main-menu:hover { background-color: #34495e; color: #fff; }
.main-menu.active { background-color: #1a252f; color: #3498db; border-left: 4px solid #3498db; }
.arrow-icon { font-size: 10px; }

.sub-menu-list { background-color: #1a252f; padding: 5px 0; }
.sub-menu { padding: 10px 20px 10px 35px; font-size: 13px; color: #95a5a6; cursor: pointer; transition: color 0.2s; }
.sub-menu:hover { color: #fff; }
.sub-menu.active { color: #fff; font-weight: bold; background-color: #2c3e50; }

/* 내비게이션 버튼 스타일 */
.navigation-buttons {
  padding: 15px 20px;
  border-top: 1px solid #34495e;
  display: flex;
  flex-direction: column;
  gap: 10px;
}
.navigation-buttons .btn {
  width: 100%;
  background-color: #34495e;
  color: #ecf0f1;
  border: 1px solid #4a627a;
  font-weight: bold;
}
.navigation-buttons .btn:hover {
  background-color: #4a627a;
}

/* 2. 메인 콘텐츠 스타일 */
.main-content { flex: 1; padding: 20px; overflow-x: hidden; }
.container { max-width: 1200px; margin: 0 auto; background: #fff; padding: 20px; border-radius: 8px; box-shadow: 0 1px 3px rgba(0,0,0,0.1); }
.header { display: flex; justify-content: space-between; align-items: center; border-bottom: 1px solid #e9ecef; padding-bottom: 15px; margin-bottom: 15px; }
.header h1 { font-size: 20px; margin: 0; color: #212529; }
.total-progress { font-size:14px; font-weight:bold; color:#495057; margin-right:15px; }

/* 탭, 가이드박스 및 테이블 공통 스타일 */
.tabs { display: flex; gap: 5px; border-bottom: 2px solid #dee2e6; margin-bottom: 20px; }
.tab { padding: 10px 20px; border: 1px solid transparent; border-bottom: none; background: #f1f3f5; cursor: pointer; border-radius: 4px 4px 0 0; font-size: 14px; font-weight: 500; color: #495057; }
.tab.active { background: #fff; border-color: #dee2e6; border-bottom: 2px solid #fff; margin-bottom: -2px; color: #007bff; font-weight: bold; }

.action-bar { display: flex; justify-content: space-between; align-items: center; margin-bottom: 15px; }
.btn { padding: 8px 14px; border-radius: 4px; font-size: 13px; cursor: pointer; border: 1px solid #ced4da; background: #fff; color: #333; }
.btn-primary { background-color: #28a745; color: white; border: none; font-weight: bold; }
.btn-secondary { background-color: #6c757d; color: white; border: none; }

.scenario-box { background: #f8f9fa; border: 1px dashed #ced4da; padding: 15px; border-radius: 6px; margin-bottom: 20px; display: flex; justify-content: space-between; align-items: center; }
.scenario-box span { font-size: 13px; color: #6c757d; }

table { width: 100%; border-collapse: collapse; font-size: 13px; }
th, td { padding: 12px; text-align: left; border-bottom: 1px solid #dee2e6; }
th { background-color: #f1f3f5; color: #495057; font-weight: 600; }

.progress-container { width: 100%; background-color: #e9ecef; border-radius: 4px; height: 12px; overflow: hidden; }
.progress-bar { height: 100%; width: 0%; transition: width 0.3s ease; }

/* 애니메이션 효과 */
.slide-enter-active, .slide-leave-active { transition: all 0.3s ease-out; max-height: 200px; overflow: hidden; }
.slide-enter-from, .slide-leave-to { max-height: 0; opacity: 0; }


.my-work-container {
  font-family: 'Malgun Gothic', 'Noto Sans KR', sans-serif;
  background-color: #ffffff;
  padding: 0 0 15px 0;
  box-sizing: border-box;
  width: 100%;
}

button {
  background: none;
  border: none;
  cursor: pointer;
  padding: 0;
}

/* 1. 상단 탭 영역 */
.tab-header {
  display: flex;
  justify-content: space-between;
  align-items: center;
  border-bottom: 1px solid #dcdcdc;
  height: 40px;
  padding-right: 15px;
}

.tab {
  display: flex;
  align-items: center;
  border: 1px solid #dcdcdc;
  border-bottom: none;
  border-top-left-radius: 8px;
  border-top-right-radius: 8px;
  padding: 6px 16px;
  background-color: #ffffff;
  height: 100%;
  box-sizing: border-box;
  margin-left: 10px;
}

.badge-integrated {
  background-color: #e2f5ec;
  color: #03a65a;
  font-size: 11px;
  font-weight: bold;
  padding: 1px 4px;
  border-radius: 10px;
  margin-right: 6px;
}

.tab-title {
  font-size: 14px;
  font-weight: bold;
  color: #333;
  margin-right: 15px;
}

.btn-close {
  font-size: 16px;
  color: #999;
}

.header-utilities {
  display: flex;
  align-items: center;
  gap: 20px;
}

.arrow-group {
  display: flex;
  border: 1px solid #e0e0e0;
  border-radius: 4px;
  overflow: hidden;
}

.btn-arrow {
  padding: 2px 8px;
  font-size: 10px;
  color: #666;
  background-color: #fcfcfc;
}
.btn-arrow:first-child {
  border-right: 1px solid #e0e0e0;
}

.icon-group {
  display: flex;
  align-items: center;
  gap: 15px;
}

.btn-icon {
  font-size: 18px;
  color: #555;
  position: relative;
}

.badge-notification::after {
  content: '';
  position: absolute;
  top: 0;
  right: 0;
  width: 5px;
  height: 5px;
  background-color: #ff4d4d;
  border-radius: 50%;
}

/* 2. 본문 타이틀 영역 */
.title-section {
  display: flex;
  justify-content: space-between;
  align-items: center;
  margin-top: 20px;
  padding: 0 20px;
}

.title-section h2 {
  margin: 0;
  font-size: 20px;
  font-weight: bold;
  color: #111;
}

.breadcrumb {
  font-size: 12px;
  color: #888;
}
.breadcrumb span:last-child {
  color: #03a65a;
  font-weight: 500;
}

/* 3. 대시보드 요약 카드 영역 */
.summary-dashboard {
  display: flex;
  gap: 12px;
  padding: 20px;
}

.summary-card {
  flex: 1;
  display: flex;
  justify-content: space-between;
  align-items: center;
  border: 1px solid #e2e8f0;
  border-radius: 8px;
  padding: 14px 20px;
  background-color: #ffffff;
  box-shadow: 0 1px 3px rgba(0,0,0,0.02);
}

/* 금주 마감 카드에만 빨간 테두리 적용 */
.summary-card.highlight-red {
  border-color: #fca5a5;
}

.summary-card .label {
  font-size: 14px;
  color: #444;
}

.summary-card .count {
  font-size: 14px;
}
.summary-card .count strong {
  font-size: 18px;
  margin-right: 2px;
}

/* 요약 카드 수치별 색상 정의 */
.count.black { color: #111; }
.count.teal { color: #0ea5e9; } /* 내 할일 하늘/청록 계열 */
.count.red { color: #ef4444; } /* 금주 마감 */
.count.orange { color: #f97316; } /* 지연 */

/* 4. 하단 컨트롤러 영역 */
.controller-section {
  display: flex;
  justify-content: space-between;
  align-items: center;
  padding: 0 20px 10px 20px;
}

.filter-left {
  display: flex;
  align-items: center;
}

.filter-title {
  font-size: 14px;
  font-weight: bold;
  color: #111;
  margin-right: 4px;
}

.filter-count {
  font-size: 14px;
  font-weight: bold;
  color: #333;
  margin-right: 10px;
}

.small-arrow-group {
  display: flex;
  border: 1px solid #dcdcdc;
  border-radius: 3px;
}

.btn-small-arrow {
  padding: 2px 6px;
  font-size: 9px;
  color: #777;
  background-color: #fff;
}
.btn-small-arrow:first-child {
  border-right: 1px solid #dcdcdc;
}

.view-switch-right {
  display: flex;
  gap: 8px;
}

.btn-switch {
  border: 1px solid #ced4da;
  border-radius: 4px;
  padding: 6px 14px;
  font-size: 13px;
  color: #666;
  background-color: #ffffff;
}

.btn-switch.active {
  border-color: #03a65a;
  color: #03a65a;
  font-weight: bold;
}

/*
"dependencies": {
  "axios": "^1.x.x",
  ...
}
*/
</style>