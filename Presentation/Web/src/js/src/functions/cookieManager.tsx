function getCookie(cookieName: string) {
  let name = cookieName + "=";
  let decodedCookie = decodeURIComponent(document.cookie);
  let ca = decodedCookie.split(";");
  for (let i = 0; i < ca.length; i++) {
    let c = ca[i];
    while (c.charAt(0) === " ") {
      c = c.substring(1);
    }
    if (c.indexOf(name) === 0) {
      return c.substring(name.length, c.length);
    }
  }
  return "";
}

function setCookie(cookieName: string, cookieValue: string) {
  const d = new Date();
  d.setTime(d.getTime() + 1000 * 60 * 60 * 10);
  let expires = "expires=" + d.toUTCString();
  document.cookie = cookieName + "=" + cookieValue + ";" + expires + ";path=/";
}

function removeCookie(cookieName: string) {
  document.cookie =
    cookieName + "=;expires=Thu, 01 Jan 1970 00:00:00 UTC;path=/;";
}

export { getCookie, setCookie, removeCookie };
