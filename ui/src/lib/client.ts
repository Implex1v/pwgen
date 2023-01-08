export async function getPassword(length = 32): Promise<PasswordResponse> {
    const response = await fetch(`https://api.cloud.toelke.me/pwgen/password?lengeth=${length}`, {method: "POST"});
    const json = await response.json();
    return {
        length: length,
        password: json.password,
    }
}

export interface PasswordResponse {
    password: string,
    length: number,
}