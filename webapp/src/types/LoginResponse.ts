export interface LoginResponse {
  username: string;
  roles: string[];
  accessToken: string;
  refreshToken: string;
}
