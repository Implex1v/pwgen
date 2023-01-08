export function GET() {
    return new Response(String(JSON.stringify({ status: "OK" })), {
        status: 200,
        headers: { "Content-Type": "application/json" },
    });
}
