export default {
  baseURL: 'http://localhost:8080/',

  userLoginApi:     { url: '/login'},
  userRegisterApi:  { url: '/register'},
  userInfoApi:      { url: '/index'},

  organizerActList: { url: '/activityByCreator'},

  organizerAddAct:  { url: '/addActivity'},
  organizerModifyAct: { url: '/updateActivity'},
  // organizerModifyActSeats: { url: ''},
  organizerCloseAct:  { url: '/closeActivity'},
  organizerAddNotice:  { url: '/addNotice'},

  participantActList:  { url: '/activity'},
  participantJoinAct:  { url: ''},
  participantGetSeatMap:  { url: ''},
  participantChooseSeat:  { url: ''},
}
